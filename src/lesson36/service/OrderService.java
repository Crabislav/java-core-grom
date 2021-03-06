package lesson36.service;

import lesson36.exceptions.BadRequestException;
import lesson36.model.Order;
import lesson36.model.Room;
import lesson36.model.User;
import lesson36.repository.OrderRepository;
import lesson36.repository.RoomRepository;
import lesson36.repository.UserRepository;

import java.util.Date;

public class OrderService extends Service {
    private static final OrderRepository orderRepository = new OrderRepository();
    private static final RoomRepository roomRepository = new RoomRepository();
    private static final UserRepository userRepository = new UserRepository();

    public void bookRoom(long roomId, long userId, Date dateFrom, Date dateTo) throws Exception {
        validateDate(dateFrom, dateTo);

        Room room = roomRepository.findObjById(roomId);
        if (room == null) {
            throw new BadRequestException("Room (id=" + roomId + ") wasn't found");
        }

        Date roomDateAvailableFrom = room.getDateAvailableFrom();
        if (!roomDateAvailableFrom.equals(dateFrom) || roomDateAvailableFrom.after(dateFrom)) {
            throw new BadRequestException(
                    "bookRoom: Room(id=" + room.getId() +
                            ", dateAvailableFrom=" + room.getDateAvailableFrom() +
                            ", hotel id=" + room.getHotel().getId() +
                            ")" +
                            "is not available now");
        }

        room.setDateAvailableFrom(dateTo);

        User user = userRepository.findObjById(userId);
        if (user == null) {
            throw new BadRequestException("User with id=" + userId + ") wasn't found");
        }

        Order order = new Order(user, room, dateFrom, dateTo, room.getPrice());
        orderRepository.save(order);
    }

    public void cancelReservation(long roomId, long userId) throws Exception {
        String methodName = "cancelReservation : ";

        Room room = roomRepository.findObjById(roomId);
        if (room == null) {
            throw new BadRequestException(methodName + "Room (id=" + roomId + ") wasn't found");
        }

        User user = userRepository.findObjById(userId);
        if (user == null) {
            throw new BadRequestException(methodName + "User (id=" + userId + ") wasn't found");
        }

        for (Order order : orderRepository.getAllObjects()) {
            if (order.getRoom().getId() == roomId && order.getUser().getId() == userId) {
                orderRepository.remove(order);

                roomRepository.remove(room);
                room.setDateAvailableFrom(new Date());
                roomRepository.save(room);
                return;
            }
        }

        throw new BadRequestException(methodName + ": order was not found");
    }

    private void validateDate(Date dateFrom, Date dateTo) throws BadRequestException {
        String methodName = "validateDate";

        if (dateFrom == null || dateTo == null) {
            throw new BadRequestException(methodName + ": date can't be null");
        }

        if (dateFrom.after(dateTo)) {
            throw new BadRequestException(methodName + ": dateFrom can't be after dateTo");
        }
    }

}
