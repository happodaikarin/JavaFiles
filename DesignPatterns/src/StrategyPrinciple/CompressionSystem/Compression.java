package StrategyPrinciple.CompressionSystem;


import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class Compression {
    CompressionStrategy cs;

    public Compression() {
    }

    public void setCompressionStrategy(CompressionStrategy cs) {
        this.cs = cs;
    }

    public void executeCompression(List<File> files) {
        cs.compress(files);
    }


    public static void main(String[] args) {
        Compression compression = new Compression();
        compression.setCompressionStrategy(new RarCompression());
        compression.executeCompression(List.of(new File("file1"), (new File("file2")), (new File("file3"))));
    }
}
