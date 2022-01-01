# 学生成绩管理系统(JAVA大作业版)

**最近JAVA大作业要求写一个学生成绩管理系统，特此记录一下**

![img](https://gitee.com/Misakisssssas/springcloud-image/raw/master/202201012315242.jpg)

#### 项目技术栈

* **SpringBoot**
* **SpringData JPA**
* **Thymeleaf**

**其余的前置技术栈以及零碎的我就不细列举啦。**

## 如何开始？

#### 1、环境准备：

* **JAVA：jdk1.8及以上**

* **数据库：MySQL8版本及以上**
* **SQL脚本导入：将项目路径下的SQL文件导入到你自己的数据库里**
* **确保自己计算机的8081端口可用，当然也可以自己改变端口**

#### 2、更改配置

这里要改动配置文件即  resources 目录下的 applicational.yml 

![image-20220101231818498](https://gitee.com/Misakisssssas/springcloud-image/raw/master/202201012318617.png)

这里将框住的部分的数据库改为自己的数据库，数据库用户名密码改为自己的即可。

#### 3、另外说明

默认所有的用户，无论是学生，教师，管理员其密码都是 12345678 。

***



#### 现在你已经完成了全部的配置，这时直接运行 访问 localhost:8081 看到登录页面即代表成功

![image-20220101232508702](https://gitee.com/Misakisssssas/springcloud-image/raw/master/202201012325956.png)

**PS：另外，如果出现问题：请确认是否是浏览器版本过低或者浏览器自身原因导致访问不出来。**