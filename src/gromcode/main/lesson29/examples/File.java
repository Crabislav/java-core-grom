package gromcode.main.lesson29.examples;

public class File implements Comparable<File> {
    private String fileName;
    private long sizeInBytes;

    public File(String fileName, long sizeInBytes) {
        this.fileName = fileName;
        this.sizeInBytes = sizeInBytes;
    }

    public String getFileName() {
        return fileName;
    }

    public long getSizeInBytes() {
        return sizeInBytes;
    }

    @Override
    public int compareTo(File file) {
        int res = 0;
        if (file.getSizeInBytes() > this.sizeInBytes) {
            res = 1;
        } else if (file.getSizeInBytes() < this.sizeInBytes) {
            res = -1;
        }
        return res;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        File file = (File) o;

        return fileName != null ? fileName.equals(file.fileName) : file.fileName == null;
    }

    @Override
    public int hashCode() {
        return fileName != null ? fileName.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "File{" +
                "fileName='" + fileName + '\'' +
                ", sizeInBytes=" + sizeInBytes +
                '}';
    }
}
