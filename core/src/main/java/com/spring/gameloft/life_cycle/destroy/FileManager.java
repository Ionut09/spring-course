package com.spring.gameloft.life_cycle.destroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.io.File;

@Lazy
@Component
public class FileManager implements InitializingBean, DisposableBean {
    String filePath;
    File file;

    @Autowired
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing bean");
        if (filePath == null) {
            throw new RuntimeException(
                    "You must set filePath property of beans " + this.getClass().getSimpleName());
        }
        file = new File(filePath);
        file.createNewFile();
    }

    @Override
    public void destroy() throws Exception {
        if (!file.delete()) {
            throw new RuntimeException("Couldn't delete file for " + filePath);
        }
        System.out.println("File has been deleted" + !file.exists());
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        ctx.getBean(FileManager.class);
        ((AnnotationConfigApplicationContext) ctx).close();
    }


}
