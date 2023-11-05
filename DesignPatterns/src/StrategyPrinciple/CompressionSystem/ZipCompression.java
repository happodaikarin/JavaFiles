package StrategyPrinciple.CompressionSystem;

import java.io.File;
import java.util.List;

public class ZipCompression implements CompressionStrategy{
    @Override
    public void compress(List<File> files) {
        System.out.println("Files compressed using ZipCompression");
    }
}