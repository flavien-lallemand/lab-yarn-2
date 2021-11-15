package com.opstty.mapper;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class MaxHeightKindsMapper extends Mapper<Object, Text, Text, FloatWritable> {
    private Text kind = new Text();

    public int i = 0;

    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        if (i != 0) {
            kind = new Text(value.toString().split(";")[3]);

            context.write(kind, new FloatWritable(Float.parseFloat(value.toString().split(";")[6])));

        } i++;
    }
}
