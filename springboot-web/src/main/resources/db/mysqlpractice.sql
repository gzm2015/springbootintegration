#Tony

#content input Tony result null
SELECT * FROM zp_message_content WHERE content REGEXP '[123]Tony';
#content input Tony result 3Tony
SELECT * FROM zp_message_content WHERE content REGEXP '[123]Tony';


#content input To.ny result 3Tony 对特殊符号 。 进行转义处理
SELECT * FROM zp_message_content WHERE content REGEXP '\\.';
#character classer 必须套两层中括号 input . 333.66 result 333.66
SELECT content FROM zp_message_content WHERE content REGEXP '[[:alnum:]]';
#input 333.66 6666.66 目的匹配四位四位数开头
SELECT content FROM zp_message_content WHERE content REGEXP '^[[:digit:]]{4}\\.[[:digit:]]{2}';

#concat 拼接练习  将表zp_message_content yifang_name 和 content进行拼接 变 json
#result 深圳市国安汽车新能源汽车服务有限公司(6666.66)
SELECT concat(yifang_name,'(',content,')') FROM zp_message_content;
#RTRIM 右侧空格去掉
SELECT CONCAT(RTRIM(yifang_name),'(',content,')') as vent_title FROM zp_message_content;
#now
SELECT now();


################################函数##################################
#文本处理  abc  返回左边的字符
SELECT LEFT('abcd',3);
SELECT RIGHT('ffddF',3);
SELECT LENGTH('abcd');
SELECT UPPER('abcdef');
SELECT LOWER('abEFFef');
#abEFFef
SELECT SUBSTRING('abEFFef',1);
#3
SELECT LOCATE('EF','abEFFef');

##########################日期处理##################################
#DUAL 空表  now 的几种写法
SELECT NOW() FROM DUAL;
SELECT NOW();
SELECT CURRENT_TIMESTAMP;
SELECT LOCALTIME;
SELECT LOCALTIMESTAMP;

# sysdate 是执行到的时候取当前的系统时间 now 是开始执行sql的时候 取的时间
SELECT SYSDATE();
#2018-06-19 21:42:17	0	2018-06-19 21:42:17
SELECT NOW(), SLEEP(3), NOW();
#2018-06-19 21:42:50	0	2018-06-19 21:42:53
SELECT SYSDATE(), SLEEP(3), SYSDATE();

SELECT CURDATE();
SELECT CURRENT_DATE;
SELECT CURTIME();
SELECT CURRENT_TIME;
SELECT DATE_FORMAT(now(),'%Y年%m月%d日 %H时%i分%s秒');
SELECT DATE_FORMAT(now(),'%Y%m%d');

#字符串转日期
SELECT STR_TO_DATE('2017/12/3','%Y/%m/%d');

SELECT TIMESTAMPADD(DAY, 1, '2017-05-15 08:12:25');
SELECT DATE_ADD('2017-05-15 08:12:25', INTERVAL 1 DAY);

SELECT TIMESTAMPDIFF(YEAR, '2017-06-01', '2016-05-15');-- -1
SELECT TIMESTAMPDIFF(MONTH, '2017-06-01', '2016-06-15');-- -11
SELECT TIMESTAMPDIFF(DAY, '2017-06-01', '2016-06-15');-- -351

#
UPDATE zp_message_content SET content = NULL WHERE uuid = '20180416_1832_7175900348562452';
#对具有值的特定列进行计数忽略Null值
SELECT count(content) FROM zp_message_content;
