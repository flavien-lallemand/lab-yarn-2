package com.opstty.mapper;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.Arrays;

public class TreesMapper extends Mapper<Object, Text, Text, IntWritable> {
    private final static IntWritable one = new IntWritable(1);
    private Text rounding = new Text();

    public void map(Object key, Text value, Context context)
            throws IOException, InterruptedException {
        String[] vals = value.toString().split(";");
        rounding.set(vals[1]);
        System.out.println(rounding.toString());
        context.write(rounding, one);
    }
}
