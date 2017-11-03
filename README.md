# itbcatBoot

spring boot 练习框架。

![](https://github.com/ITBCat/itbcatBoot/blob/master/src/main/resources/static/i_b%20.png?raw=true)

## plan
1. 文章列表（前、后）
2. 各个列表的分页
3. 跟人信息详情页

## nginx 代理
```
    server {
        listen       9008;
        server_name  localhost;

		location ~* \.(html|css|js|png|jpg|gif|ico)$ {
         	root /Users/BrickCat/IdeaProjects/itbcatBoot/upload/;
     	}

        location = /50x.html {
            root   html;
        }

    }
    
    location /Image{
           #当访问Image 文件夹的时候指定映射到真正的物理地址
        alias J:\FTPFinCloud;
            #默认的图片
        index default.png;
        }
    #缓存图片
    location ~.*.(gif|jpg|jpeg|png|bmp|swf)${
        expires 10d;
    }

```
mvn package -DskipTests

### ES配置

springboot的版本是1.5.8，对应的ES的版本是2.0.0

允许 elasticsearch-head 运行时的跨域：
```
# allow origin
http.cors.enabled: true
http.cors.allow-origin: "*"
```