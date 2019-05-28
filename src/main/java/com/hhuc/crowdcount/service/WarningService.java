package com.hhuc.crowdcount.service;

import com.hhuc.crowdcount.dao.WarningDao;
import com.hhuc.crowdcount.model.Camera_danger;
import com.hhuc.crowdcount.model.WarningLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


/***
 *
 * 发送邮件
 * */
@Component
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class WarningService {
    @Autowired
    WarningDao warningDao;

    @Autowired
    MailService mailService;

    //3.添加定时任务
    @Scheduled(cron = "0/5 * * * * ?")
    //或直接指定时间间隔，例如：5秒
    //@Scheduled(fixedRate=5000)
    @Transactional
    public void configureTasks() {
//        System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
        List<Camera_danger> camera_dangers = warningDao.getAllCameraDangerList();
        System.out.println("监测到下列摄像头");
        for (Camera_danger camera_danger : camera_dangers)
            System.out.println(camera_danger);

        for (Camera_danger camera_danger : camera_dangers) {
            System.out.println(camera_danger);
            int camera_id = camera_danger.getCamera_id();
            WarningLog warningLog = warningDao.getNewCameraDangerById(camera_danger.getCamera_id());
//            System.out.println(warningLog);
            Date now = new Date();
            long times = 0;
            if (warningLog == null || warningLog.getSend_time() == null)
                times = now.getTime();
            else
                times = now.getTime() - warningLog.getSend_time().getTime();

            if (times > 10 * 60000) {
                warningLog = warningDao.getWarningLogById(camera_id);
                System.out.println("warningLog" + warningLog);
                warningLog.setSend_time(now);
                warningDao.insertwarninglog(warningLog);
                String title = "人流量超标紧急通知";
                String text = "尊敬的" + warningLog.getUser_name() + "负责人,您所监管的" + warningLog.getCamera_place() + "地区监测到人流量过大，请及时疏散人群";
                String email = warningLog.getUser_email();
                mailService.sendMail(title, text, email);
                System.out.println("发送邮件给" + text + "邮箱：" + email);
            }
            warningDao.updateCameraDanger();
            System.out.println("更新完毕");
        }


    }
}
