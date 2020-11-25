package com.elead.bai.service;

import java.util.Date;
import java.util.Timer;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService
{
	@Scheduled(cron="0/5 * * * * *")
	public void healthCheck1(){
		System.out.println(Thread.currentThread().getName()+"当前时间1："+new Date().toLocaleString());
	}
	
	@Scheduled(cron="0/5 * * * * *")
	public void healthCheck2(){
		System.out.println(Thread.currentThread().getName()+"当前时间2："+new Date().toLocaleString());
	}
	@Scheduled(cron="0/5 * * * * *")
	public void healthCheck3(){
		System.out.println(Thread.currentThread().getName()+"当前时间3："+new Date().toLocaleString());
	}
	@Scheduled(cron="0/5 * * * * *")
	public void healthCheck4(){
		System.out.println(Thread.currentThread().getName()+"当前时间4："+new Date().toLocaleString());
	}
	@Scheduled(cron="0/5 * * * * *")
	public void healthCheck5(){
		System.out.println(Thread.currentThread().getName()+"当前时间5："+new Date().toLocaleString());
	}
}
