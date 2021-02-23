# Table To Word

#### 介绍
由于PowerDesigner连接mysql8驱动有些问题，故写了该项目。
从mysql数据库导出数据结构生成数据库word文档。

#### 架构说明
springboot + mybatis + mysql

#### 使用说明
1. git clone https://github.com/wb123852/Table2Word.git
2. cd Table2Word
3. mvn clean package -Dmaven.test.skip
4. java -jar target/table2word.jar --url=127.0.0.1:3306 --database=dev --user=root --password=123456
5. 数据库文档生成在out目录下

#### 开源项目
觉得有用的大佬可以给个star；
觉得不妥的地方可以上传修改；

#### 参与贡献
1. git remote origin set-url https://github.com/wb123852/Table2Word.git
2. git checkout branch
3. commit
4. push

欢迎各位大佬补充。
