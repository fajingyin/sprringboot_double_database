package com.yin.databaseproject.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yin
 * @Date 2019/9/14 14:16
 * @Method
 */
public class TimeTask implements SimpleJob {
    @Override
    public void execute(ShardingContext shardingContext) {
        String jobName = shardingContext.getJobName();
        int shardingItem = shardingContext.getShardingItem();
        System.out.println(shardingItem+":::"+jobName);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss:SSS");

        String date =formatter.format(new Date());
        System.out.println("123333"+date);
    }
}
