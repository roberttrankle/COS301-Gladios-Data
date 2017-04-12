package cos301;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.common.functions.FlatMapFunction;

import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.KeyedStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.timestamps.AscendingTimestampExtractor;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.util.Collector;

/**
 *
 * @author rob
 */
public class DataStreamGeo {
    public static void main(String[] args) throws Exception 
    {
        //check input paramaeters
        final ParameterTool parms = ParameterTool.fromArgs(args);
        
        //making the execution environment
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        
        env.getConfig().setGlobalJobParameters(parms);
        
        DataStream<String> geolocation;
        if(parms.has("input"))
        {
            geolocation = env.readTextFile(parms.get("input"));
        }
        else
        {
            System.out.println("Executing data transfer with default values");
            geolocation = env.fromElements("there are no coordinates");
        }
        
        DataStream<Tuple2<String, Integer>> cnt = geolocation.flatMap( new flatMapper() ).keyBy(0).sum(1);
        
        if (parms.has("output")) 
        {
            cnt.writeAsText(parms.get("output"));
        } 
        else 
        {
            System.out.println("Printing result to stdout. Use --output to specify output path.");
            cnt.print();
        }

        // execute program
        env.execute("Streaming WordCount");
    }
    
    public static final class flatMapper implements FlatMapFunction<String, Tuple2<String, Integer>> {
        private static final long serialVersionUID = 1L;

        @Override
        public void flatMap(String value, Collector<Tuple2<String, Integer>> out)throws Exception 
        {
            // normalize and split the line
            String[] tokens = value.toLowerCase().split("\\W+");

            // emit the pairs
            for (String token : tokens) 
            {
                if (token.length() > 0) 
                {
                    out.collect(new Tuple2<String, Integer>(token, 1));
                }
            }
	}
    }
}
