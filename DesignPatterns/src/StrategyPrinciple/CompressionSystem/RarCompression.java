package StrategyPrinciple.CompressionSystem;

import java.io.File;
import java.util.List;

public class RarCompression implements CompressionStrategy{
    @Override
    public void compress(List<File> files) {

        System.out.println("Files "+files+" compressed using RarCompression");

    }
}
