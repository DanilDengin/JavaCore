package academy.tochkavhoda.file;

import academy.tochkavhoda.colors.v3.ColorException;
import academy.tochkavhoda.figures.v3.ColoredRectangle;
import academy.tochkavhoda.figures.v3.Rectangle;
import academy.tochkavhoda.school.Trainee;
import academy.tochkavhoda.school.TrainingException;
import com.google.gson.Gson;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileService {

    public static void writeByteArrayToBinaryFile(String fileName, byte[] array) throws IOException {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileName))) {
            for (byte item : array) {
                bos.write(item);
            }
        }
    }

    public static void writeByteArrayToBinaryFile(File file, byte[] array) throws IOException {
        writeByteArrayToBinaryFile(file.getAbsolutePath(), array);
    }

    public static byte[] readByteArrayFromBinaryFile(String fileName) throws IOException {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileName))) {
            return bis.readAllBytes();
        }
    }

    public static byte[] readByteArrayFromBinaryFile(File file) throws IOException {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file.getName()))) {
            return bis.readAllBytes();
        }
    }

    public static byte[] writeAndReadByteArrayUsingByteStream(byte[] array) throws IOException {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            for (int i = 0; i < array.length - 1; i = i + 2) {
                bos.write(array[i]);
            }
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            return bis.readAllBytes();
        }
    }

    public static void writeByteArrayToBinaryFileBuffered(String fileName, byte[] array) throws IOException {
        writeByteArrayToBinaryFile(fileName, array);
    }

    public static void writeByteArrayToBinaryFileBuffered(File file, byte[] array) throws IOException {
        writeByteArrayToBinaryFile(file, array);
    }

    public static byte[] readByteArrayFromBinaryFileBuffered(String fileName) throws IOException {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileName))) {
            return bis.readAllBytes();
        }
    }

    public static byte[] readByteArrayFromBinaryFileBuffered(File file) throws IOException {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file.getName()))) {
            return bis.readAllBytes();
        }
    }

    public static void writeRectangleToBinaryFile(File file, Rectangle rect) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file.getAbsolutePath()))) {
            dos.writeInt(rect.getTopLeft().getX());
            dos.writeInt(rect.getTopLeft().getY());
            dos.writeInt(rect.getBottomRight().getX());
            dos.writeInt(rect.getBottomRight().getY());
        }
    }

    public static Rectangle readRectangleFromBinaryFile(File file) throws IOException {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(file.getAbsolutePath()))) {
            int a1 = dis.readInt();
            int a2 = dis.readInt();
            int a3 = dis.readInt();
            int a4 = dis.readInt();
            Rectangle rect = new Rectangle(a1, a2, a3, a4);
            return rect;
        }
    }

    public static void writeColoredRectangleToBinaryFile(File file, ColoredRectangle rect) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file.getAbsolutePath()))) {
            dos.writeInt(rect.getTopLeft().getX());
            dos.writeInt(rect.getTopLeft().getY());
            dos.writeInt(rect.getBottomRight().getX());
            dos.writeInt(rect.getBottomRight().getY());
            dos.writeUTF(rect.getColor().toString());
        }
    }

    public static ColoredRectangle readColoredRectangleFromBinaryFile(File file) throws IOException {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(file.getAbsolutePath()))) {
            int a1 = dis.readInt();
            int a2 = dis.readInt();
            int a3 = dis.readInt();
            int a4 = dis.readInt();
            String color = dis.readUTF();
            ColoredRectangle rect = new ColoredRectangle(a1, a2, a3, a4, color);
            return rect;
        } catch (ColorException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeRectangleArrayToBinaryFile(File file, Rectangle[] rects) throws IOException {
        try (RandomAccessFile ros = new RandomAccessFile(file.getAbsolutePath(), "rw")) {
            for (Rectangle rect : rects) {
                ros.writeInt(rect.getTopLeft().getX());
                ros.writeInt(rect.getTopLeft().getY());
                ros.writeInt(rect.getBottomRight().getX());
                ros.writeInt(rect.getBottomRight().getY());
            }
        }
    }

    public static Rectangle[] readRectangleArrayFromBinaryFileReverse(File file) throws IOException {
        try (RandomAccessFile ras = new RandomAccessFile(file.getAbsolutePath(), "rw")) {
            Rectangle[] rects = new Rectangle[(int) file.length() / 16];
            for (int i = 0; i < file.length() / 16; i++) {
                ras.seek(64 - i * 16);
                int a1 = ras.readInt();
                int a2 = ras.readInt();
                int a3 = ras.readInt();
                int a4 = ras.readInt();
                Rectangle rect = new Rectangle(a1, a2, a3, a4);
                rects[i] = rect;
            }
            return rects;
        }
    }

    public static void writeRectangleToTextFileOneLine(File file, Rectangle rect) throws IOException {
        writeRectangleToBinaryFile(file, rect);
    }

    public static Rectangle readRectangleFromTextFileOneLine(File file) throws IOException {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(file.getAbsolutePath()))) {
            int a1 = dis.readInt();
            int a2 = dis.readInt();
            int a3 = dis.readInt();
            int a4 = dis.readInt();
            Rectangle rect = new Rectangle(a1, a2, a3, a4);
            return rect;
        }
    }

    public static void writeRectangleToTextFileFourLines(File file, Rectangle rect) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file.getAbsolutePath()))) {
            dos.writeInt(rect.getTopLeft().getX());
            dos.writeChar('\n');
            dos.writeInt(rect.getTopLeft().getY());
            dos.writeChar('\n');
            dos.writeInt(rect.getBottomRight().getX());
            dos.writeChar('\n');
            dos.writeInt(rect.getBottomRight().getY());
        }
    }

    public static Rectangle readRectangleFromTextFileFourLines(File file) throws IOException {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(file.getAbsolutePath()))) {
            int a1 = dis.readInt();
            dis.skipBytes(2);
            int a2 = dis.readInt();
            dis.skipBytes(2);
            int a3 = dis.readInt();
            dis.skipBytes(2);
            int a4 = dis.readInt();
            Rectangle rect = new Rectangle(a1, a2, a3, a4);
            return rect;
        }
    }

    public static void writeTraineeToTextFileOneLine(File file, Trainee trainee) throws IOException {
        try (OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file.getAbsolutePath()), "UTF-8")) {
            Gson gson = new Gson();
            gson.toJson(trainee, osw);
        }
    }

    public static Trainee readTraineeFromTextFileOneLine(File file) throws IOException {
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(file.getAbsolutePath()), "UTF-8")) {
            Gson gson = new Gson();
            return gson.fromJson(isr, (Trainee.class));
        }
    }

    public static void writeTraineeToTextFileThreeLines(File file, Trainee trainee) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsolutePath(), StandardCharsets.UTF_8))) {
            bw.write(trainee.getFirstName() + "\n" + trainee.getLastName() + "\n" + trainee.getRating());
        }
    }

    public static Trainee readTraineeFromTextFileThreeLines(File file) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath(), StandardCharsets.UTF_8))) {
            String line1 = br.readLine();
            String line2 = br.readLine();
            String line3 = br.readLine();
            Integer mark = Integer.valueOf(line3);
            return new Trainee(line1, line2, mark);
        } catch (TrainingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void serializeTraineeToBinaryFile(File file, Trainee trainee) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file.getAbsolutePath()))) {
            oos.writeObject(trainee);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Trainee deserializeTraineeFromBinaryFile(File file) throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file.getAbsolutePath()))) {
            return (Trainee) ois.readObject();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static String serializeTraineeToJsonString(Trainee trainee) {
        Gson gson = new Gson();
        return gson.toJson(trainee);
    }

    public static Trainee deserializeTraineeFromJsonString(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Trainee.class);
    }

    public static void serializeTraineeToJsonFile(File file, Trainee trainee) throws IOException {
        try (FileWriter fr = new FileWriter(file.getAbsolutePath())) {
            Gson gson = new Gson();
            gson.toJson(trainee, fr);
        }
    }

    public static Trainee deserializeTraineeFromJsonFile(File file) throws IOException {
        try (FileReader fr = new FileReader(file.getAbsolutePath())) {
            Gson gson = new Gson();
            return gson.fromJson(fr, Trainee.class);
        }
    }


}











