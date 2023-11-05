package StrategyPrinciple.CompressionSystem;

import java.io.File;
import java.util.List;

public class TarGzCompression implements CompressionStrategy{
    @Override
    public void compress(List<File> files) {

        System.out.println("File compressed using TarGz");

    }
}
