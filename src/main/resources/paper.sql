/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50549
Source Host           : localhost:3306
Source Database       : intelligentpaper

Target Server Type    : MYSQL
Target Server Version : 50549
File Encoding         : 65001

Date: 2018-08-22 19:06:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bigques
-- ----------------------------
DROP TABLE IF EXISTS `bigques`;
CREATE TABLE `bigques` (
  `b_id` int(11) NOT NULL AUTO_INCREMENT,
  `k_id` int(11) DEFAULT NULL,
  `c_id` int(11) DEFAULT NULL,
  `p_id` int(11) DEFAULT '4',
  `qc_id` int(11) DEFAULT NULL,
  `title` varchar(2000) DEFAULT NULL,
  `difficultyLevel` int(11) DEFAULT NULL,
  `answer` varchar(255) DEFAULT NULL,
  `selectedNum` int(11) DEFAULT '0',
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`b_id`),
  KEY `c_id` (`c_id`),
  KEY `k_id` (`k_id`),
  KEY `qc_id` (`qc_id`),
  KEY `p_id` (`p_id`),
  CONSTRAINT `bigques_ibfk_1` FOREIGN KEY (`c_id`) REFERENCES `course` (`c_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `bigques_ibfk_2` FOREIGN KEY (`k_id`) REFERENCES `knowledge` (`k_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `bigques_ibfk_3` FOREIGN KEY (`qc_id`) REFERENCES `quescate` (`q_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `bigques_ibfk_4` FOREIGN KEY (`p_id`) REFERENCES `probcate` (`p_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=118 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bigques
-- ----------------------------
INSERT INTO `bigques` VALUES ('89', '2', '1', '4', '5', 'a）定义一个抽象类Shape，包含属性边长length，抽象方法area()；\nb)定义等腰直角三角形类Triangle，继承Shape类。实现area()方法，在屏幕上显示等腰直角三角形的面积；\nc)定义正方形类Square，继承Shape类。实现area()方法，在屏幕上显示正方形面积；\nd)在主程序中定义两个Triangle对象和两个Square对象，4个对象存放于一个数组中，用循环程序打印出三角形和正方形的面积。', '1', '程序设计答案', '0', '普通测试题');
INSERT INTO `bigques` VALUES ('90', '2', '1', '4', '5', 'a）定义一个抽象类Shape，包含属性边长length，抽象方法Draw()；\nb) 定义等腰直角三角形类Triangle，继承Shape类。实现Draw()方法，输出为：cout<<\"T\"<<endl;\nc) 定义正方形类Square，继承Shape类。实现Draw()方法，输出为：cout<<\"S\"<<endl;\nd) 在主程序中定义两个Triangle对象和两个Square对象，4个对象存放于一个数组中，用循环程序访问其Draw方法，使Triangle和Square对象能够正确实现其相应的Draw方法。', '1', '程序设计答案', '0', '普通测试题');
INSERT INTO `bigques` VALUES ('91', '2', '1', '4', '5', 'a）定义一个抽象类Square，包含属性边长length，抽象方法draw()；\nb)定义实心正方形类ConcreteSquare，继承Square类。实现draw()方法，使用“*”在屏幕上绘制实心正方形；\nc)定义空心正方形类HollowSquare，继承Square类。实现draw()方法，使用“*”在屏幕上绘制空心正方形（仅画出正方形的四条边）；\nd)在主程序中定义两个ConcreteSquare对象和两个HollowSquare对象，4个对象存放于一个数组中，用循环程序打印出实心正方形和空心正方形。', '1', '程序设计答案', '0', '普通测试题');
INSERT INTO `bigques` VALUES ('92', '2', '1', '4', '5', '定义一个Circle （圆形）类，具体要求如下：\na) 数据成员包含圆形外接正方形的左上角顶点和右下角顶点；\nb) 构造函数：给圆形的外接矩形左上角和右下角顶点位置坐标赋初值。如果只给定一个坐标(x,y)时,则认为是给定外接矩形左上角顶点坐标的直径为1的圆形；\nc)  重载操作符“==”：判断当前圆形对象是否与另一个圆形对象形状相同，返回值为布尔类型；\nd)  成员函数float Area()用于计算圆形的面积;\ne) 重载操作符\"<\":判断当前圆形对象是否包含于另一个圆形对象中，返回值为布尔类型。', '1', '程序设计答案', '0', '普通测试题');
INSERT INTO `bigques` VALUES ('93', '2', '1', '4', '5', '定义一个Circle（圆形）类，具体要求如下：\na) 数据成员包含圆形的中心点位置坐标和半径；\nb) 构造函数：给圆形的中心点位置坐标和半径赋初值。如果只给定一个坐标(x,y)时,则认为是半径为1的圆形；如果只给定半径r时，则认为是中心点在(0,0)，半径为r的圆形；\nc)  重载操作符“<”：判断当前圆对象是否包含于另外一个圆对象内，返回值为布尔类型；\nd)  成员函数float Area()用于计算圆的面积。', '1', '程序设计答案', '0', '普通测试题');
INSERT INTO `bigques` VALUES ('94', '2', '1', '4', '5', '定义一个Rectangle（矩形）类，具体要求如下：\na)构造函数：可以给定一对矩形的位置坐标（左上和右下的坐标）；默认情况下，矩形左上坐标为（0，0）右下坐标为（width，hight）；如果只给定一个坐标（x,y）时,则认为是给定的右下的坐标；\nb)重载操作符 <  ：能够完成对某一矩形对象所在区域是否包含在该对象区域进行判断，返回值为布尔类型；\nc)float Area():求出该矩形的面积，并返回该面积的结果；\nd)析构函数：输出矩形坐标。\n', '4', '程序设计答案', '0', '普通测试题');
INSERT INTO `bigques` VALUES ('95', '2', '1', '4', '5', '定义一个Rectangle类，它包含两个数据成员length和width；以及包含用于求长方形面积的成员函数double Area()。再定义Rectangle的派生类长方体类Cuboid，它包含一个新数据成员height和用来求长方体体积的成员函数double Volume()。并要求重载“==”运算符,能够判断两个长方形的大小是否相等，以及两个长方体的体积是否相同。在主函数中定义2个长方形和2个长方体，输出其中2个长方形的length、width和Area,其中2个长方体的length、width、height以及Volume，并输出判定两个长方形是否相等和两个长方体是否相等的信息。', '4', '程序设计答案', '0', '普通测试题');
INSERT INTO `bigques` VALUES ('96', '2', '1', '4', '5', '定义一个Square（正方形）类，具体要求如下：\na) 数据成员包含正方形的左上角位置坐标和边长；\nb) 构造函数：给正方形的左上角位置坐标和边长赋初值。如果只给定一个坐标(x,y)时,则认为是边长为1的正方形；如果只给定边长l时，则认为是左上角在(0,0)，边长为l的正方形；\nc)  重载操作符“<”：判断当前正方形对象是否包含于另外一个正方形对象内，返回值为布尔类型；\nd)  成员函数float Area()用于计算正方形的面积。\n\n', '4', '程序设计答案', '0', '普通测试题');
INSERT INTO `bigques` VALUES ('97', '2', '1', '4', '5', '定义一个表示形状的基类Shape类和它的派生类圆形类（Circle)、正方形类（Square)，具体要求如下：\na) 基类Shape中有虚函数area()和perimeter(),实现求形状的面积和周长，可用cout输出表示。\nb) 在main函数中，每个派生类生成两个对象，共四个对象存放于一个数组中，用循环程序访问其求面积和周长的成员函数。\n\n输入输出样例参考：\n输入形状类型及其边长或半径：Square  5.15\n输入形状类型及其边长或半径：Square  2.10\n输入形状类型及其边长或半径：Circle  3.28\n输入形状类型及其边长或半径：Circle  2.01\nSquare  26.52  20.60\nSquare  4.41  8.40\nCircle  33.80  20.61\nCircle  12.69  12.63\n', '4', '程序设计答案', '0', '普通测试题');
INSERT INTO `bigques` VALUES ('98', '2', '1', '4', '5', '定义一个模板顺序表SequentialList<T>,具体要求如下：\na) 实现插入 void Add(T item)。\nb) 实现计算最大值T GetMax(void)。\nc) 建立学生类Student，包含学号、身高 2个成员变量。学生之间按照学号排序。\nd) 向学生类添加必要的成员函数或友元函数，以确保SequentialList<Student> 能够执行 GetMax(void)。\n', '4', '程序设计答案', '0', '普通测试题');
INSERT INTO `bigques` VALUES ('99', '2', '1', '4', '5', '建立分数类Fraction,其中包含成员分子num和分母den。具体要求如下：\na) 重载“+”实现两个分数相加操作；\nb) 重载“-”实现两个分数相减操作；\nc) 重载“>”和“<”,比较两个分数的大小；\nd) 重载“>>”和“<<”以输入输出分数。\n\n输入输出样例参考：\n输入分数：1  3\n输入分数：1  2\nA+B: 5/6\nA-B: -1/6\nA>B: false\nA<B: true\n', '4', '程序设计答案', '0', '普通测试题');
INSERT INTO `bigques` VALUES ('100', '2', '1', '4', '5', '建立复数类Complex，其中包含成员实部real和虚部imag。具体要求如下：\na) 重载“+”实现两个复数相加操作；\nb) 重载“*”实现两个复数相乘操作（注：(a+bi)*(c+di)=ac-bd+(bc+ad)i）；\nc) 重载“>”和“<”，比较两个复数模的大小（注：复数a+bi的模=sqrt(a*a+b*b)）；\nd) 重载“<<”以输出复数。\n\n输入输出样例参考：\n输入复数1：3  4\n输入复数2：5  6\n两复数相加结果：8+10i\n两复数相乘结果：-9+38i\n两复数大小：复数1小于复数2\n', '4', '程序设计答案', '0', '普通测试题');
INSERT INTO `bigques` VALUES ('101', '2', '1', '4', '5', '建立节日类Holiday,其中包含成员年、月、日。年月日格式如：1999-12-1，具体要求如下：\na) 重载“>”和“<”实现当前节日对象表示的时间早于和晚于某个节日对象的时间。\nb) 重载“==”实现当前节日对象表示的时间等于某个节日对象的时间。\nc) 重载“>>”实现按年、月、日格式输入。 \nd) 重载“<<”实现按年、月、日格式输出。', '4', '程序设计答案', '0', '普通测试题');
INSERT INTO `bigques` VALUES ('102', '2', '1', '4', '5', '建立生日类Birthday,其中包含成员年、月、日。年月日格式如：1979.4.1，具体要求如下：\na) 重载“>”和“<”实现当前生日对象表示的时间早于和晚于某个生日对象的时间。\nb) 重载“==”实现当前生日对象表示的时间等于某个生日对象的时间。\nc) 重载“>>”实现按年、月、日格式输入。 \nd) 重载“<<”实现按年、月、日格式输出。', '3', '程序设计答案', '0', '普通测试题');
INSERT INTO `bigques` VALUES ('103', '2', '1', '4', '5', '将时、分、秒表示的时间用一个CTime类表示。具体要求如下：\na) 重载“>”和“<”实现当前时间对象表示的时间大于和小于某个对象的时间。\nb) 重载“==”实现当前时间对象表示的时间等于某个对象的时间。\nc) 重载“>>”实现按时间格式输入。 \nd) 重载“<<”实现按时间格式输出。\ne) 析构函数：输出当前时间', '3', '程序设计答案', '0', '普通测试题');
INSERT INTO `bigques` VALUES ('104', '2', '1', '4', '5', '将时、分、秒表示的时间用一个CTime类表示。时间格式如：18:45:56，具体要求如下：\na) 重载“>”和“<”实现当前时间对象表示的时间大于和小于某个对象的时间。\nb) 重载“==”实现当前时间对象表示的时间等于某个对象的时间。\nc) 重载“>>”实现按时间格式输入。 \nd) 重载“<<”实现按时间格式输出。', '3', '程序设计答案', '0', '普通测试题');
INSERT INTO `bigques` VALUES ('105', '2', '1', '4', '5', '设计包含编号、姓名和工资属性的员工类Employee，基本要求如下：\na）数据成员的访问权限设定为保护型，并定义公有的成员函数获取数据成员；\nb）定义计算工资的成员函数；\nc）实现输出员工信息的成员函数；', '3', '程序设计答案', '0', '普通测试题');
INSERT INTO `bigques` VALUES ('106', '2', '1', '4', '5', '设计二维点类Point，基本要求如下：\na）设计用于获取和设置x和y坐标分量的公有成员函数；\nb）设计一个用于计算两点距离的公有成员函数；\nc）设计一个用于移动点的公有成员函数；', '3', '程序设计答案', '0', '普通测试题');
INSERT INTO `bigques` VALUES ('107', '2', '1', '4', '5', '设计矩形类Rectangle，基本要求如下：\na）能够计算面积和周长；\nb）能够缩放和移动；', '3', '程序设计答案', '0', '普通测试题');
INSERT INTO `bigques` VALUES ('108', '2', '1', '4', '5', '设计三角形类Triangle，基本要求如下：\na）判断三条边长的合法性；\nb）能够计算面积和周长；\nc）能够缩放和移动；', '3', '程序设计答案', '0', '普通测试题');
INSERT INTO `bigques` VALUES ('109', '2', '1', '4', '5', '设计一个基类Animal和它的派生类Cat，Dog，实现以下要求：\na) 基类Animal中有保护成员变量name，纯虚函数Talk();\nb) 猫类Cat，继承Animal类。实现Talk()方法，输出为：cout<<name<<\" MiaoMiao\"<<endl;\nc) 狗类Dog，继承Animal类。实现Talk()方法，输出为：cout<<name<<\" WangWang\"<<endl;\nd) 在main函数中，每个派生类生成两个对象，共四个对象存放于一个数组中，用循环程序访问其“叫”的成员函数，使Cat和Dog对象能够正确的实现其对应的“叫”动作。\n\n输入输出样例参考：\n输入动物类型及其名称：Dog 旺财\n输入动物类型及其名称：Cat 皮皮\n输入动物类型及其名称：Dog 小白\n输入动物类型及其名称：Cat 蓝妮\n旺财 WangWang\n皮皮 MiaoMiao\n小白 WangWang\n蓝妮 MiaoMiao\n', '3', '程序设计答案', '0', '普通测试题');
INSERT INTO `bigques` VALUES ('110', '2', '1', '4', '5', '设计一个顺序堆栈类模板CStack，其中数据成员包含T data[N] (其中N为常量，表示栈中能存放的最大元素个数)和指向栈顶元素的索引值int top，成员函数包含:\n（1）bool IsEmpty()用于判断堆栈是否为空；bool IsFull()用于判断堆栈是否为满；\n（2）void Push(T elem)入栈操作；T Pop()出栈操作;\n（3）采用CStack栈模板分别实现对一个整型数组的逆向输出和一个字符串的逆向输出。', '3', '程序设计答案', '0', '普通测试题');
INSERT INTO `bigques` VALUES ('111', '2', '1', '4', '5', '设计一个由年、月、日组成的日期类Date，基本要求如下：\na）定义成员函数IsLeapYear，判断当前日期是否为闰年；\nb）将关系运算符重载为友元，实现两个日期对象的比较；', '3', '程序设计答案', '0', '普通测试题');
INSERT INTO `bigques` VALUES ('112', '2', '1', '4', '5', '设计一维动态整型数组类Vect，基本要求如下：\na）在构造函数和析构函数中动态管理内存；\nb）拷贝构造函数和重载的赋值运算符均采用深拷贝；\nc）重载下标运算符获取和设置指定元素；\nd）可以用整型数组初始化Vect对象；', '3', '程序设计答案', '0', '普通测试题');
INSERT INTO `bigques` VALUES ('113', '2', '1', '4', '5', '设计银行帐户类Account，基本要求如下：\na）设计一个用于表示存款年利率interestRate的静态数据成员；\nb）设计一个用于表示当前存款金额deposit的私有数据成员；\nc）设计一个用于计算年利息的公有成员函数GetAnnualInterest（注：年利息=存款金额*年利率）；\nd）设计一个用于修改存款年利率的静态成员函数ModifyInterestRate。\n\n输入输出样例参考：\n输入当前存款金额和年利率：10000  0.0325\n客户年利息：325\n输入新的年利率：0.04\n客户年利息：400\n', '2', '程序设计答案', '0', '普通测试题');
INSERT INTO `bigques` VALUES ('114', '2', '1', '4', '5', '设计圆形类Circle，基本要求如下：\na）能够计算面积和周长；\nb）能够缩放和移动。', '2', '程序设计答案', '0', '普通测试题');
INSERT INTO `bigques` VALUES ('115', '2', '1', '4', '5', '设计整型单链表类SingleList，基本要求如下：\na）能够实现节点的插入和删除；\nb）能够实现节点的查找。', '2', '程序设计答案', '0', '普通测试题');
INSERT INTO `bigques` VALUES ('116', '2', '1', '4', '5', '设计一个顺序堆栈类模板CStack，其中数据成员包含T data[N] (其中N为常量，表示栈中能存放的最大元素个数)和指向栈顶元素的索引值int top，成员函数包含:\n（1）bool IsEmpty()用于判断堆栈是否为空；bool IsFull()用于判断堆栈是否为满；\n（2）void Push(T elem)入栈操作；T Pop()出栈操作;\n（3）采用CStack栈模板分别实现对一个整型数组的逆向输出和一个字符串的逆向输出。', '2', '程序设计答案', '0', '普通测试题');
INSERT INTO `bigques` VALUES ('117', '2', '1', '4', '5', '文件压缩。通过文件压缩程序，可将一个文件压缩为一个新文件，新文件称为压缩文件，压缩文件比原文件要小，且通过解压缩程序能够将压缩文件还原为原文件。压缩文件的方案很多，本题要求采用行程长度编码法实现数据压缩。设原文件是由‘0’和‘1’两种字符组成的一幅图像（见输入样例），其中第一行给定了图像的长度和宽度。行程长度编码即按重复出现字符次数代替原文件中连续重复的字符。例如：”0000011110000000111100000”，由于依次出现5个0、4个1、7个0、4个1和5个0，因此可用”5 4 7 4 5”表示。要求补充行程长度编码类，实现将输入样例所示文本格式图像文件(*.txt)压缩为一个新文件(*.dat)。\n#include <iostream>\n#include <fstream>\nusing namespace std;\n\nclass CRunLenEncode\n{\n    int m;//图像文件数据行数\n    int n;//图像文件数据列数\n    char **a;//存储图像数据的二级字符指针\npublic:\n    CRunLenEncode()\n　　{\n        m = n = 0;\n        a = NULL;\n    }\n     ~CRunLenEncode()\n　　{\n　　//在此补充析构函数代码\n　　//提示：动态释放字符指针a所指内存\n    }\n    bool ReadFile(char *inFileName)\n　　{\n  //在此补充读入文本文件字符信息代码\n　　//提示：使用ifstream，并注意对字符指针a的动态内存分配\n    }\n    bool Compress(char *outFileName)\n　　{ \n　　//在此补充对读入图像数据进行压缩的代码\n　　//提示：使用ofstream \n    }\n};\n\nint main()\n{\n    CRunLenEncode RLE;  //建立压缩文件对象\n    RLE.ReadFile(\"A.txt\");  //A.txt为原始文件\n    RLE.Compress(\"A.dat\"); //A.dat为压缩文件\n　　return 0;\n}\n输入样例：\nA.txt文件中的内容：\n24 24\n000000000000000000000000\n000000000011110000000000\n000000000011111000000000\n000000000111111000000000\n000000000111111000000000\n000000001111111100000000\n000000001110011100000000\n000000001110011110000000\n000000011110001110000000\n000000011100001110000000\n000000011100001111000000\n000000111100000111000000\n000000111000000111100000\n000001111000000111100000\n000001111000000011100000\n000001111111111111110000\n000011111111111111110000\n000011111111111111111000\n000111100000000001111000\n000111100000000000111000\n000111000000000000111100\n001111000000000000111100\n001111000000000000011110\n000000000000000000000000\n输出样例：\nA.dat中的内容：\n24 \n10 4 10 \n10 5 9 \n9 6 9 \n9 6 9 \n8 8 8 \n8 3 2 3 8 \n8 3 2 4 7 \n7 4 3 3 7 \n7 3 4 3 7 \n7 3 4 4 6 \n6 4 5 3 6 \n6 3 6 4 5 \n5 4 6 4 5 \n5 4 7 3 5 \n5 15 4 \n4 16 4 \n4 17 3 \n3 4 10 4 3 \n3 4 11 3 3 \n3 3 12 4 2 \n2 4 12 4 2 \n2 4 13 4 1 \n24 ', '2', '程序设计答案', '0', '普通测试题');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `courseName` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', 'java程序设计');
INSERT INTO `course` VALUES ('2', '大学物理');
INSERT INTO `course` VALUES ('3', '大学英语');
INSERT INTO `course` VALUES ('4', 'c++程序设计');
INSERT INTO `course` VALUES ('9', 'python实战');

-- ----------------------------
-- Table structure for fillblankques
-- ----------------------------
DROP TABLE IF EXISTS `fillblankques`;
CREATE TABLE `fillblankques` (
  `f_id` int(11) NOT NULL AUTO_INCREMENT,
  `k_id` int(11) DEFAULT NULL,
  `c_id` int(11) DEFAULT NULL,
  `p_id` int(11) DEFAULT '2',
  `qc_id` int(11) DEFAULT NULL,
  `title` varchar(500) DEFAULT NULL,
  `difficultyLevel` int(11) DEFAULT NULL,
  `answer` varchar(500) DEFAULT NULL,
  `selectedNum` int(11) DEFAULT '0',
  `blankNum` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`f_id`),
  KEY `k_id` (`k_id`),
  KEY `c_id` (`c_id`),
  KEY `qc_id` (`qc_id`),
  KEY `p_id` (`p_id`),
  CONSTRAINT `fillblankques_ibfk_1` FOREIGN KEY (`k_id`) REFERENCES `knowledge` (`k_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fillblankques_ibfk_2` FOREIGN KEY (`c_id`) REFERENCES `course` (`c_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fillblankques_ibfk_3` FOREIGN KEY (`qc_id`) REFERENCES `quescate` (`q_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fillblankques_ibfk_4` FOREIGN KEY (`p_id`) REFERENCES `probcate` (`p_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=153 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fillblankques
-- ----------------------------
INSERT INTO `fillblankques` VALUES ('1', '2', '1', '2', '4', '面向对象三大特性:____、____、____', '1', '封装、继承、多态', '0', '3', '2016中科大考研题');
INSERT INTO `fillblankques` VALUES ('2', '2', '1', '2', '4', '子类可以通过____的方式对父类的方法进行增强', '1', '重写', '0', '1', '11月联考题');
INSERT INTO `fillblankques` VALUES ('78', '1', '1', '2', '4', '[blank]10[/blank]容器中的数据元素不存储在顺序的线性数据结构中，它们提供了一个关键字（key）到值的关联映射。', '3', '关联容器', '0', '1', '2015期末考题');
INSERT INTO `fillblankques` VALUES ('79', '1', '1', '2', '4', '[blank]10[/blank]是C++提供的标准模板库，它可以实现高效的泛型程序设计。', '3', 'stl', '0', '1', '2016期末考题');
INSERT INTO `fillblankques` VALUES ('80', '1', '1', '2', '4', '[blank]20[/blank]容器中的数据元素存储在一棵平衡二叉树中，提供了一个关键字(key)到值的映射，并且允许关键字的重复。', '3', 'multimap', '0', '1', '2017期末考题');
INSERT INTO `fillblankques` VALUES ('81', '1', '1', '2', '4', 'C++标准库的名字空间为[blank]10[/blank]。', '2', 'std', '0', '1', '2018期末考题');
INSERT INTO `fillblankques` VALUES ('82', '1', '1', '2', '4', 'C++标准库中的字符串类的头文件是[blank]16[/blank]。', '2', 'string', '0', '1', '2019期末考题');
INSERT INTO `fillblankques` VALUES ('83', '1', '1', '2', '4', 'STL的基本元素包括容器、算法、[blank]10[/blank]和函数对象。', '2', '迭代器', '0', '1', '2020期末考题');
INSERT INTO `fillblankques` VALUES ('84', '1', '1', '2', '4', 'STL容器主要包含顺序容器和关联容器，其中[blank]20[/blank]中元素的添加或插入位置与元素的值无关。', '2', '顺序容器', '0', '1', '2021期末考题');
INSERT INTO `fillblankques` VALUES ('85', '1', '1', '2', '4', 'STL中，利用[blank]10[/blank]可以将顺序容器转换为新的容器。', '2', '容器适配器', '0', '1', '2022期末考题');
INSERT INTO `fillblankques` VALUES ('86', '1', '1', '2', '4', '在STL中，[blank]10[/blank]如同一个特殊的指针（用以指向容器中某个位置的数据元素）。', '2', '迭代器', '0', '1', '2023期末考题');
INSERT INTO `fillblankques` VALUES ('87', '1', '1', '2', '4', 'C++的动态多态性是通过[blank]10[/blank]实现的。', '2', '虚函数', '0', '1', '2024期末考题');
INSERT INTO `fillblankques` VALUES ('88', '1', '1', '2', '4', 'C++支持两种多态性，即静态多态性和动态多态性，其中函数重载属于[blank]10[/blank]。', '2', '静态多态', '0', '1', '2025期末考题');
INSERT INTO `fillblankques` VALUES ('89', '1', '1', '2', '4', 'Gardelli和Wegner将多态性分为强制多态性、[blank]16[/blank]、包含多态性和参数多态性。', '2', '重载多态性', '0', '1', '2026期末考题');
INSERT INTO `fillblankques` VALUES ('90', '1', '1', '2', '4', '定义重载函数时，应至少使重载函数参数的类型或[blank]10[/blank]不同。', '2', '个数', '0', '1', '2027期末考题');
INSERT INTO `fillblankques` VALUES ('91', '1', '1', '2', '4', '函数名相同，但对应形参表不同的一组函数称为[blank]10[/blank]。', '2', '重载函数', '0', '1', '2028期末考题');
INSERT INTO `fillblankques` VALUES ('92', '1', '1', '2', '4', '函数重载实现了[blank]10[/blank]的重用。', '2', '函数名', '0', '1', '2029期末考题');
INSERT INTO `fillblankques` VALUES ('93', '1', '1', '2', '4', '内联函数的展开、重载函数的绑定、类模板的实例化与绑定均在[blank]10[/blank]阶段进行。', '2', '编译', '0', '1', '2030期末考题');
INSERT INTO `fillblankques` VALUES ('94', '1', '1', '2', '4', '如果一个类包含一个或多个[blank]10[/blank]，则该类为抽象类。', '2', '纯虚函数', '0', '1', '2031期末考题');
INSERT INTO `fillblankques` VALUES ('95', '1', '1', '2', '4', '若将一个二元运算符重载为类的成员函数，其形参个数应该是[blank]4[/blank]个。', '2', '1.0', '0', '1', '2032期末考题');
INSERT INTO `fillblankques` VALUES ('96', '1', '1', '2', '4', '虚函数的声明方法是在函数原型前加上关键字[blank]10[/blank]。', '2', 'virtual', '0', '1', '2033期末考题');
INSERT INTO `fillblankques` VALUES ('97', '1', '1', '2', '4', '运算符重载实现的是[blank]10[/blank]多态性。', '2', '编译', '0', '1', '2034期末考题');
INSERT INTO `fillblankques` VALUES ('98', '1', '1', '2', '4', '在C++类中，有一种不能定义对象的类，这样的类只能被继承，称为[blank]10[/blank]。', '2', '抽象类', '0', '1', '2035期末考题');
INSERT INTO `fillblankques` VALUES ('99', '1', '1', '2', '4', '重载“=”操作符时，应声明为[blank]10[/blank]函数', '2', '成员', '0', '1', '2036期末考题');
INSERT INTO `fillblankques` VALUES ('100', '1', '1', '2', '4', '作为类的成员函数重载一个运算符时，参数表中只有一个参数，说明该运算符有[blank]10[/blank]个操作数。', '2', '2.0', '0', '1', '2037期末考题');
INSERT INTO `fillblankques` VALUES ('101', '1', '1', '2', '4', '3种常见的面向对象编程语言有Java，C#，[blank]10[/blank]。', '2', 'C++', '0', '1', '2038期末考题');
INSERT INTO `fillblankques` VALUES ('102', '1', '1', '2', '4', 'C++程序可以利用关键字[blank]16[/blank]来定义名字空间以减少名称冲突。', '2', 'namespace', '0', '1', '2039期末考题');
INSERT INTO `fillblankques` VALUES ('103', '1', '1', '2', '4', 'C++是一种支持多种程序设计范型的编程语言，支持面向过程、基于对象、[blank]10[/blank]和泛型程序设计。', '2', '面向对象', '0', '1', '2040期末考题');
INSERT INTO `fillblankques` VALUES ('104', '1', '1', '2', '4', '带inline关键字定义的函数为[blank]10[/blank]。', '2', '内联函数', '0', '1', '2041期末考题');
INSERT INTO `fillblankques` VALUES ('105', '1', '1', '2', '4', '对象的[blank]10[/blank]用于描述对象的静态特征，对象的方法用于描述对象的动态特征。', '2', '属性', '0', '1', '2042期末考题');
INSERT INTO `fillblankques` VALUES ('106', '1', '1', '2', '4', '封装是面向对象程序设计的基本特性，把数据和[blank]10[/blank]合成一个整体。', '2', '方法', '0', '1', '2043期末考题');
INSERT INTO `fillblankques` VALUES ('107', '1', '1', '2', '4', '面向对象程序设计的四个基本特征是抽象性、[blank]10[/blank]、继承性和多态性。', '2', '封装性', '0', '1', '2044期末考题');
INSERT INTO `fillblankques` VALUES ('108', '1', '1', '2', '4', '面向对象程序设计通过[blank]10[/blank]和动态绑定机制扩展了基于对象程序设计。', '2', '继承机制', '0', '1', '2045期末考题');
INSERT INTO `fillblankques` VALUES ('109', '1', '1', '2', '4', '如果一个对象是用[blank]10[/blank]操作符动态生成的，则应用delete操作符来销毁该对象。', '2', 'new', '0', '1', '2046期末考题');
INSERT INTO `fillblankques` VALUES ('110', '1', '1', '2', '4', '为了提高程序执行效率，通常使用关键字[blank]10[/blank]将一些需要频繁调用的简短函数定义为内联函数。', '2', 'inline', '0', '1', '2047期末考题');
INSERT INTO `fillblankques` VALUES ('111', '1', '1', '2', '4', '如果用new动态创建对象，则应用[blank]10[/blank]销毁该对象。', '4', 'delete', '0', '1', '2048期末考题');
INSERT INTO `fillblankques` VALUES ('112', '1', '1', '2', '4', '运算符[blank]10[/blank]在堆上建立一个大小合适的对象并返回一个具有正确类型的指针。', '4', 'new', '0', '1', '2049期末考题');
INSERT INTO `fillblankques` VALUES ('113', '1', '1', '2', '4', '在面向对象的程序设计中，将一组对象的共同特性抽象出来形成[blank]10[/blank]。', '4', '类', '0', '1', '2050期末考题');
INSERT INTO `fillblankques` VALUES ('114', '1', '1', '2', '4', '自增和自减都是[blank]10[/blank]元运算。', '4', '1.0', '0', '1', '2051期末考题');
INSERT INTO `fillblankques` VALUES ('115', '1', '1', '2', '4', '[blank]10[/blank]是面向对象的核心之一，也是一种复用已有类的机制。', '4', '继承', '0', '1', '2052期末考题');
INSERT INTO `fillblankques` VALUES ('116', '1', '1', '2', '4', '当一个派生类具有多个基类时，这种继承方式称为[blank]10[/blank]。', '4', '多继承', '0', '1', '2053期末考题');
INSERT INTO `fillblankques` VALUES ('117', '1', '1', '2', '4', '定义派生类时，其访问限定符的缺省值为[blank]10[/blank]。', '4', 'private', '0', '1', '2054期末考题');
INSERT INTO `fillblankques` VALUES ('118', '1', '1', '2', '4', '基类的公有成员在私有派生类中是私有成员，基类的保护成员在公有派生类中是[blank]10[/blank]成员。', '4', '保护', '0', '1', '2055期末考题');
INSERT INTO `fillblankques` VALUES ('119', '1', '1', '2', '4', '派生类的成员一般分为两部分，一部分是[blank]10[/blank] ，另一部分是自己定义的新成员。', '4', '基类成员', '0', '1', '2056期末考题');
INSERT INTO `fillblankques` VALUES ('120', '1', '1', '2', '4', '如果一个派生类只有唯一的基类，这种继承关系称为[blank]10[/blank]。', '4', '单继承', '0', '1', '2057期末考题');
INSERT INTO `fillblankques` VALUES ('121', '1', '1', '2', '4', '在派生类的声明中，基类可以有一个，也可以有多个。如果只有一个基类，这种继承方式称单一继承；如果基类有多个，则这种继承方式称为[blank]10[/blank]。', '1', '多重继承', '0', '1', '2058期末考题');
INSERT INTO `fillblankques` VALUES ('122', '1', '1', '2', '4', '在派生类中不能直接访问基类的[blank]10[/blank]成员。', '1', '私有', '0', '1', '2059期末考题');
INSERT INTO `fillblankques` VALUES ('123', '1', '1', '2', '4', '只有在[blank]10[/blank]继承的情况下，基类和派生类之间才有赋值兼容性规则。', '1', '公有', '0', '1', '2060期末考题');
INSERT INTO `fillblankques` VALUES ('124', '1', '1', '2', '4', '[blank]10[/blank]是具有相同属性和行为的一组对象的抽象。', '1', '类', '0', '1', '2061期末考题');
INSERT INTO `fillblankques` VALUES ('125', '1', '1', '2', '4', '[blank]10[/blank]为该类的所有对象所共享。', '1', '静态成员', '0', '1', '2062期末考题');
INSERT INTO `fillblankques` VALUES ('126', '1', '1', '2', '4', '[blank]10[/blank]指针是一个系统预定义的特殊指针，指向当前对象，表示当前对象的地址。', '1', 'this', '0', '1', '2063期末考题');
INSERT INTO `fillblankques` VALUES ('127', '1', '1', '2', '4', '当建立一个新的对象时，程序自动调用[blank]10[/blank]。', '1', '构造函数', '0', '1', '2064期末考题');
INSERT INTO `fillblankques` VALUES ('128', '1', '1', '2', '4', '当类中包含指向动态分配的内存的指针成员时，定义拷贝构造函数一般应采用[blank]6[/blank]拷贝技术。', '1', '深', '0', '1', '2065期末考题');
INSERT INTO `fillblankques` VALUES ('129', '1', '1', '2', '4', '用class定义的类中，其成员的访问权限默认为[blank]10[/blank]。', '1', 'private', '0', '1', '2066期末考题');
INSERT INTO `fillblankques` VALUES ('130', '1', '1', '2', '4', '假定AB为一个类，则该类的拷贝构造函数的原型说明为[blank]10[/blank]。', '1', 'AB::AB(AB &ab)', '0', '1', '2067期末考题');
INSERT INTO `fillblankques` VALUES ('131', '1', '1', '2', '4', '静态成员函数无this指针，它是同类的所有对象[blank]10[/blank]的资源，只有一个共用的副本。', '1', '共享', '0', '1', '2068期末考题');
INSERT INTO `fillblankques` VALUES ('132', '1', '1', '2', '4', '拷贝构造函数使用[blank]10[/blank]来初始化创建的对象。', '1', '已存在的对象', '0', '1', '2069期末考题');
INSERT INTO `fillblankques` VALUES ('133', '1', '1', '2', '4', '可以在具有类型转换功能的构造函数的声明前面加上关键字[blank]10[/blank]，禁止隐式类型转换。', '1', 'explicit', '0', '1', '2070期末考题');
INSERT INTO `fillblankques` VALUES ('134', '1', '1', '2', '4', '类的[blank]10[/blank]成员可以被类作用域内的任何对象访问。', '1', '静态', '0', '1', '2071期末考题');
INSERT INTO `fillblankques` VALUES ('135', '1', '1', '2', '4', '类的[blank]10[/blank]只能被该类的成员函数或友元函数访问。', '1', '私有成员', '0', '1', '2072期末考题');
INSERT INTO `fillblankques` VALUES ('136', '1', '1', '2', '4', '类的数据成员不能在类定义的时候初始化，而应该通过[blank]10[/blank]初始化。', '1', '构造函数', '0', '1', '2073期末考题');
INSERT INTO `fillblankques` VALUES ('137', '1', '1', '2', '4', '类中成员的访问权限可以分为公有、[blank]10[/blank]和私有。', '1', '保护', '0', '1', '2074期末考题');
INSERT INTO `fillblankques` VALUES ('138', '1', '1', '2', '4', '每个对象都有一个指向自身的指针，称为[blank]10[/blank]指针，通过使用它来确定其自身的地址。', '1', 'this', '0', '1', '2075期末考题');
INSERT INTO `fillblankques` VALUES ('139', '1', '1', '2', '4', '如果类的定义中没有显式初始化对象成员，则系统将调用该对象的[blank]16[/blank]以实现初始化。', '1', '缺省构造函数', '0', '1', '2076期末考题');
INSERT INTO `fillblankques` VALUES ('140', '1', '1', '2', '4', '如果某个类的名字为MyClass，那么该类的构造函数的函数名可以命名为MyClass，该类的析构函数的函数名可以命名为~MyClass。注销对象时，系统自动调用[blank]10[/blank]。', '1', '析构函数', '0', '1', '2077期末考题');
INSERT INTO `fillblankques` VALUES ('141', '1', '1', '2', '4', '设p是指向一个类动态对象的指针变量，则执行delete p语句时，将自动调用该类的[blank]10[/blank]。', '5', '析构函数', '0', '1', '2078期末考题');
INSERT INTO `fillblankques` VALUES ('142', '1', '1', '2', '4', '用class定义类时，其数据成员和成员函数的默认访问控制类型为[blank]10[/blank]。', '5', '私有', '0', '1', '2079期末考题');
INSERT INTO `fillblankques` VALUES ('143', '1', '1', '2', '4', 'iostream库中预定义了一些常用的标准流对象，包括cin、[blank]10[/blank]、cerr和clog。', '5', 'cout', '0', '1', '2080期末考题');
INSERT INTO `fillblankques` VALUES ('144', '1', '1', '2', '4', '使用cin和cout进行输入输出操作的程序必须包含头文件[blank]10[/blank]。', '5', 'iostream', '0', '1', '2081期末考题');
INSERT INTO `fillblankques` VALUES ('145', '1', '1', '2', '4', 'C++的模板声明和定义是以[blank]16[/blank]关键字开头的。', '5', 'template', '0', '1', '2082期末考题');
INSERT INTO `fillblankques` VALUES ('146', '1', '1', '2', '4', '[blank]10[/blank]能够针对不同的数据类型创建具有相似功能的类。', '5', '类模板', '0', '1', '2083期末考题');
INSERT INTO `fillblankques` VALUES ('147', '1', '1', '2', '4', '[blank]10[/blank]是指在程序设计时，将数据类型参数化，编写具有通用性和可重用的程序。', '5', '模板', '0', '1', '2084期末考题');
INSERT INTO `fillblankques` VALUES ('148', '1', '1', '2', '4', 'C++通过[blank]10[/blank]和类模板来支持泛型程序设计。', '5', '函数模板', '0', '1', '2085期末考题');
INSERT INTO `fillblankques` VALUES ('149', '1', '1', '2', '4', '泛型程序设计的核心思想是[blank]10[/blank]参数化。', '5', '数据类型', '0', '1', '2086期末考题');
INSERT INTO `fillblankques` VALUES ('150', '1', '1', '2', '4', '类的友元可以是[blank]10[/blank]、另一个类的成员函数或另一个类。', '5', '全局函数', '0', '1', '2087期末考题');
INSERT INTO `fillblankques` VALUES ('151', '1', '1', '2', '4', '友元破坏了类的[blank]10[/blank]性。', '5', '封装', '0', '1', '2088期末考题');
INSERT INTO `fillblankques` VALUES ('152', '1', '1', '2', '4', '使用C++标准库的字符串类string时，需要包含头文件[blank]10[/blank]。', '5', 'string', '0', '1', '2089期末考题');

-- ----------------------------
-- Table structure for judgeques
-- ----------------------------
DROP TABLE IF EXISTS `judgeques`;
CREATE TABLE `judgeques` (
  `j_id` int(11) NOT NULL AUTO_INCREMENT,
  `k_id` int(11) DEFAULT NULL,
  `c_id` int(11) DEFAULT NULL,
  `p_id` int(11) DEFAULT '3',
  `qc_id` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `difficultyLevel` int(11) DEFAULT NULL,
  `answer` varchar(255) DEFAULT NULL,
  `selectedNum` int(11) DEFAULT '0',
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`j_id`),
  KEY `k_id` (`k_id`),
  KEY `c_id` (`c_id`),
  KEY `qc_id` (`qc_id`),
  KEY `p_id` (`p_id`),
  CONSTRAINT `judgeques_ibfk_1` FOREIGN KEY (`k_id`) REFERENCES `knowledge` (`k_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `judgeques_ibfk_2` FOREIGN KEY (`c_id`) REFERENCES `course` (`c_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `judgeques_ibfk_3` FOREIGN KEY (`qc_id`) REFERENCES `quescate` (`q_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `judgeques_ibfk_4` FOREIGN KEY (`p_id`) REFERENCES `probcate` (`p_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=455 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of judgeques
-- ----------------------------
INSERT INTO `judgeques` VALUES ('1', '1', '1', '3', '9', '代码是否正确', '1', '√', '0', '中科大考研题');
INSERT INTO `judgeques` VALUES ('342', '2', '1', '3', '9', 'STL是通过类模板和函数模板实现的通用算法和数据结构。', '1', 'y', '0', '2015期末考题');
INSERT INTO `judgeques` VALUES ('343', '1', '1', '3', '9', '如果定义list<int>::iterator it，若需按偶数进行跳跃式访问，可采用迭代器操作it+=2。', '1', 'n', '0', '2016期末考题');
INSERT INTO `judgeques` VALUES ('344', '1', '1', '3', '9', '通用算法sort也可对string类对象进行排序操作。', '1', 'y', '0', '2017期末考题');
INSERT INTO `judgeques` VALUES ('345', '1', '1', '3', '9', 'C++语言允许在重载运算符时改变运算符原来的优先级。', '1', 'n', '0', '2018期末考题');
INSERT INTO `judgeques` VALUES ('346', '1', '1', '3', '9', '赋值运算符只能作为成员函数重载。', '1', 'y', '0', '2019期末考题');
INSERT INTO `judgeques` VALUES ('347', '1', '1', '3', '9', '函数重载可以通过函数形参个数、形参类型或返回值类型来区分同名函数。', '1', 'n', '0', '2020期末考题');
INSERT INTO `judgeques` VALUES ('348', '1', '1', '3', '9', '所有C++运算符都可以重载。', '1', 'n', '0', '2021期末考题');
INSERT INTO `judgeques` VALUES ('349', '1', '1', '3', '9', '所有重载的运算符都必须为类的友元。', '1', 'n', '0', '2022期末考题');
INSERT INTO `judgeques` VALUES ('350', '1', '1', '3', '9', '下标运算符必须是成员函数，且只接收一个参数。', '1', 'y', '0', '2023期末考题');
INSERT INTO `judgeques` VALUES ('351', '1', '1', '3', '9', '虚函数可以是友元函数。', '1', 'n', '0', '2024期末考题');
INSERT INTO `judgeques` VALUES ('352', '1', '1', '3', '9', '虚函数使用静态绑定的函数调用机制。', '1', 'n', '0', '2025期末考题');
INSERT INTO `judgeques` VALUES ('353', '1', '1', '3', '9', '虚函数是实现动态联编的充分必要条件。', '1', 'y', '0', '2026期末考题');
INSERT INTO `judgeques` VALUES ('354', '1', '1', '3', '9', '虚函数是一个非成员函数。', '1', 'n', '0', '2027期末考题');
INSERT INTO `judgeques` VALUES ('355', '1', '1', '3', '9', '一个基类中定义有纯虚函数，该基类的派生类一定不再是抽象类。', '1', 'n', '0', '2028期末考题');
INSERT INTO `judgeques` VALUES ('356', '1', '1', '3', '9', '运算符重载以后，其优先级和结合性都不能改变。', '1', 'y', '0', '2029期末考题');
INSERT INTO `judgeques` VALUES ('357', '1', '1', '3', '9', '重载函数可以使成员函数或友元函数，而虚函数只能是成员函数。', '1', 'y', '0', '2030期末考题');
INSERT INTO `judgeques` VALUES ('358', '1', '1', '3', '9', '重载函数要求参数的个数不同。', '1', 'n', '0', '2031期末考题');
INSERT INTO `judgeques` VALUES ('359', '1', '1', '3', '9', '重载一个二元运算符时，必须声明两个形参。', '1', 'n', '0', '2032期末考题');
INSERT INTO `judgeques` VALUES ('360', '1', '1', '3', '9', 'Ada是支持抽象数据类型的代表语言之一。', '1', 'y', '0', '2033期末考题');
INSERT INTO `judgeques` VALUES ('361', '1', '1', '3', '9', 'C++程序采用分段编译方式，以源文件为单位进行编译。', '1', 'y', '0', '2034期末考题');
INSERT INTO `judgeques` VALUES ('362', '1', '1', '3', '9', 'C++程序允许有多个main()函数。', '1', 'n', '0', '2035期末考题');
INSERT INTO `judgeques` VALUES ('363', '1', '1', '3', '9', 'C++函数可以返回局部对象的指针或引用。', '2', 'n', '0', '2036期末考题');
INSERT INTO `judgeques` VALUES ('364', '1', '1', '3', '9', 'C++无需在函数定义开头就声明所需的全部变量。', '2', 'y', '0', '2037期末考题');
INSERT INTO `judgeques` VALUES ('365', '1', '1', '3', '9', 'C++允许声明引用数组，数组中的每个元素都是引用。', '2', 'n', '0', '2038期末考题');
INSERT INTO `judgeques` VALUES ('366', '1', '1', '3', '9', 'C++中定义了表示逻辑值的布尔类型，只有TRUE和FALSE两个值。', '2', 'n', '0', '2039期末考题');
INSERT INTO `judgeques` VALUES ('367', '1', '1', '3', '9', '常引用可以用直接常量初始化(如const int refx=100;)。', '2', 'y', '0', '2040期末考题');
INSERT INTO `judgeques` VALUES ('368', '1', '1', '3', '9', '定义带默认形参的函数时，默认形参值可以同时出现在函数声明和函数定义中。', '2', 'n', '0', '2041期末考题');
INSERT INTO `judgeques` VALUES ('369', '1', '1', '3', '9', '定义引用时必须初始化。', '2', 'y', '0', '2042期末考题');
INSERT INTO `judgeques` VALUES ('370', '1', '1', '3', '9', '对象可以接收的消息由它所属类的接口确定。', '2', 'y', '0', '2043期末考题');
INSERT INTO `judgeques` VALUES ('371', '1', '1', '3', '9', '对象之间是通过消息来通信的。', '2', 'y', '0', '2044期末考题');
INSERT INTO `judgeques` VALUES ('372', '1', '1', '3', '9', '封装的目的是使对象的信息隐藏。', '2', 'y', '0', '2045期末考题');
INSERT INTO `judgeques` VALUES ('373', '1', '1', '3', '9', '建立内联函数的主要目的是提高程序的执行效率。', '2', 'y', '0', '2046期末考题');
INSERT INTO `judgeques` VALUES ('374', '1', '1', '3', '9', '名称空间可以重复使用，但不可以嵌套。', '2', 'n', '0', '2047期末考题');
INSERT INTO `judgeques` VALUES ('375', '1', '1', '3', '9', '任意函数均可以定义成为内联函数。', '2', 'n', '0', '2048期末考题');
INSERT INTO `judgeques` VALUES ('376', '1', '1', '3', '9', '引用和指针都可作函数参数。\n', '2', 'y', '0', '2049期末考题');
INSERT INTO `judgeques` VALUES ('377', '1', '1', '3', '9', '引用是对象的别名，定义时需要初始化，定义之后可以引用其它对象。', '2', 'n', '0', '2050期末考题');
INSERT INTO `judgeques` VALUES ('378', '1', '1', '3', '9', '在C++中，默认形参表应该从最右边的形参开始向左边依次设置。', '2', 'n', '0', '2051期末考题');
INSERT INTO `judgeques` VALUES ('379', '1', '1', '3', '9', '自增和自减运算符都可以对常量对象操作。', '2', 'n', '0', '2052期末考题');
INSERT INTO `judgeques` VALUES ('380', '1', '1', '3', '9', '从基类派生新类时，使用关键字static可以将基类说明成虚基类。', '2', 'n', '0', '2053期末考题');
INSERT INTO `judgeques` VALUES ('381', '1', '1', '3', '9', '多重继承中出现的二义性可以用作用域分辨法消除。', '2', 'y', '0', '2054期末考题');
INSERT INTO `judgeques` VALUES ('382', '1', '1', '3', '9', '基类的protected成员在公有派生类的成员函数中可以直接使用。', '2', 'y', '0', '2055期末考题');
INSERT INTO `judgeques` VALUES ('383', '1', '1', '3', '9', '基类对象可以赋予派生类对象。', '2', 'n', '0', '2056期末考题');
INSERT INTO `judgeques` VALUES ('384', '1', '1', '3', '9', '派生类的构造函数会隐含调用基类的构造函数。', '2', 'y', '0', '2057期末考题');
INSERT INTO `judgeques` VALUES ('385', '1', '1', '3', '9', '派生类的析构函数中不包含直接基类的析构函数。', '3', 'n', '0', '2058期末考题');
INSERT INTO `judgeques` VALUES ('386', '1', '1', '3', '9', '派生类的虚函数与基类中对应的虚函数具有相同的参数个数和类型。', '3', 'y', '0', '2059期末考题');
INSERT INTO `judgeques` VALUES ('387', '1', '1', '3', '9', '派生类对象的地址可以赋予基类的指针变量。', '3', 'y', '0', '2060期末考题');
INSERT INTO `judgeques` VALUES ('388', '1', '1', '3', '9', '派生类中成员的访问权限与基类的继承方式有关。', '3', 'y', '0', '2061期末考题');
INSERT INTO `judgeques` VALUES ('389', '1', '1', '3', '9', '派生类重用基类属于包含多态性。', '3', 'y', '0', '2062期末考题');
INSERT INTO `judgeques` VALUES ('390', '1', '1', '3', '9', '所有的多重继承都会导致二义性。', '3', 'n', '0', '2063期末考题');
INSERT INTO `judgeques` VALUES ('391', '1', '1', '3', '9', '一个派生类可以作为另一个派生类的基类。', '3', 'y', '0', '2064期末考题');
INSERT INTO `judgeques` VALUES ('392', '1', '1', '3', '9', '在堆上创建的多个对象的析构顺序与构造顺序相反。', '3', 'n', '0', '2065期末考题');
INSERT INTO `judgeques` VALUES ('393', '1', '1', '3', '9', '在多继承中，公有派生和私有派生对于基类成员在派生类中的可访问性与单继承的规则是完全不同的。', '3', 'n', '0', '2066期末考题');
INSERT INTO `judgeques` VALUES ('394', '1', '1', '3', '9', '在公有继承中，基类中的公有和保护成员在派生类中的访问属性不变。', '3', 'y', '0', '2067期末考题');
INSERT INTO `judgeques` VALUES ('395', '1', '1', '3', '9', '在任何需要基类对象（或地址）的地方，都可以由其共有派生类的对象（或地址）代替。', '3', 'y', '0', '2068期末考题');
INSERT INTO `judgeques` VALUES ('396', '1', '1', '3', '9', '在销毁派生类对象时，先调用基类的析构函数，再调用派生类的析构函数。', '3', 'n', '0', '2069期末考题');
INSERT INTO `judgeques` VALUES ('397', '1', '1', '3', '9', 'const成员函数不能修改数据成员，也不能调用其他非const成员函数。', '3', 'y', '0', '2070期末考题');
INSERT INTO `judgeques` VALUES ('398', '1', '1', '3', '9', 'const对象不能调用非const成员函数，但是非const对象可以调用const成员函数。', '3', 'y', '0', '2071期末考题');
INSERT INTO `judgeques` VALUES ('399', '1', '1', '3', '9', 'const数据成员的值对类中所有对象都是一样的。', '3', 'n', '0', '2072期末考题');
INSERT INTO `judgeques` VALUES ('400', '1', '1', '3', '9', 'this是类的指针类型，指向该类的对象地址。', '3', 'y', '0', '2073期末考题');
INSERT INTO `judgeques` VALUES ('401', '1', '1', '3', '9', '成员函数可以是静态的。', '3', 'y', '0', '2074期末考题');
INSERT INTO `judgeques` VALUES ('402', '1', '1', '3', '9', '创建对象数组时，调用默认构造函数初始化每个数组元素。', '3', 'y', '0', '2075期末考题');
INSERT INTO `judgeques` VALUES ('403', '1', '1', '3', '9', '带一个参数的构造函数可以看作是能够进行类型转换的函数，可以将参数的数据类型转换为类类型。', '3', 'y', '0', '2076期末考题');
INSERT INTO `judgeques` VALUES ('404', '1', '1', '3', '9', '对象具有本体，可以通过内存地址区分不同的对象。', '3', 'y', '0', '2077期末考题');
INSERT INTO `judgeques` VALUES ('405', '1', '1', '3', '9', '构造函数必须与类名相同。', '3', 'y', '0', '2078期末考题');
INSERT INTO `judgeques` VALUES ('406', '1', '1', '3', '9', '构造函数不能带参数，但可以声明返回类型。', '3', 'n', '0', '2079期末考题');
INSERT INTO `judgeques` VALUES ('407', '1', '1', '3', '9', '构造函数和析构函数都不能重载。 ', '4', 'n', '0', '2080期末考题');
INSERT INTO `judgeques` VALUES ('408', '1', '1', '3', '9', '构造函数可以对静态数据成员进行初始化。', '4', 'n', '0', '2081期末考题');
INSERT INTO `judgeques` VALUES ('409', '1', '1', '3', '9', '即使定义了带参构造函数，系统也会提供无参构造函数。', '4', 'n', '0', '2082期末考题');
INSERT INTO `judgeques` VALUES ('410', '1', '1', '3', '9', '静态成员函数拥有this指针。', '4', 'n', '0', '2083期末考题');
INSERT INTO `judgeques` VALUES ('411', '1', '1', '3', '9', '静态成员函数中不能访问非静态数据成员，也不能调用非静态成员函数。', '4', 'y', '0', '2084期末考题');
INSERT INTO `judgeques` VALUES ('412', '1', '1', '3', '9', '静态数据成员是该类所有对象共有的数据成员。', '4', 'y', '0', '2085期末考题');
INSERT INTO `judgeques` VALUES ('413', '1', '1', '3', '9', '静态数据成员在整个类中只有一个副本。', '4', 'y', '0', '2086期末考题');
INSERT INTO `judgeques` VALUES ('414', '1', '1', '3', '9', '静态数据成员只能被静态函数操作。', '4', 'n', '0', '2087期末考题');
INSERT INTO `judgeques` VALUES ('415', '1', '1', '3', '9', '可以在类的构造函数中对静态数据成员进行初始化。', '4', 'n', '0', '2088期末考题');
INSERT INTO `judgeques` VALUES ('416', '1', '1', '3', '9', '类的定义可以嵌套。', '4', 'y', '0', '2089期末考题');
INSERT INTO `judgeques` VALUES ('417', '1', '1', '3', '9', '类的接口由对外公开的属性和操作构成。', '4', 'y', '0', '2090期末考题');
INSERT INTO `judgeques` VALUES ('418', '1', '1', '3', '9', '类定义中只能说明函数成员的函数头，不能定义函数体。', '4', 'n', '0', '2091期末考题');
INSERT INTO `judgeques` VALUES ('419', '1', '1', '3', '9', '类是对象的抽象，对象是类的实例。', '4', 'y', '0', '2092期末考题');
INSERT INTO `judgeques` VALUES ('420', '1', '1', '3', '9', '类中的私有成员可以被类外的非友元函数访问。', '4', 'n', '0', '2093期末考题');
INSERT INTO `judgeques` VALUES ('421', '1', '1', '3', '9', '利用struct关键字也可以定义类。', '4', 'y', '0', '2094期末考题');
INSERT INTO `judgeques` VALUES ('422', '1', '1', '3', '9', '没有数据成员的对象的内存大小为0。', '4', 'n', '0', '2095期末考题');
INSERT INTO `judgeques` VALUES ('423', '1', '1', '3', '9', '每个非静态成员函数都隐含有一个this指针，指向调用该成员函数的对象。', '4', 'y', '0', '2096期末考题');
INSERT INTO `judgeques` VALUES ('424', '1', '1', '3', '9', '如果在类中声明了静态数据成员，必须声明静态成员函数。', '4', 'n', '0', '2097期末考题');
INSERT INTO `judgeques` VALUES ('425', '1', '1', '3', '9', '声明一个对象时为对象所对应的数据成员分配存储空间。 ', '4', 'y', '0', '2098期末考题');
INSERT INTO `judgeques` VALUES ('426', '1', '1', '3', '9', '同一个类的对象具有相同的属性值和行为。', '4', 'n', '0', '2099期末考题');
INSERT INTO `judgeques` VALUES ('427', '1', '1', '3', '9', '同一类的每个对象都具有自已的数据成员，所有对象共享成员函数的定义。', '4', 'y', '0', '2100期末考题');
INSERT INTO `judgeques` VALUES ('428', '1', '1', '3', '9', '析构函数可以有一个或多个参数。', '5', 'n', '0', '2101期末考题');
INSERT INTO `judgeques` VALUES ('429', '1', '1', '3', '9', '析构函数是一个函数体为空的成员函数。', '5', 'n', '0', '2102期末考题');
INSERT INTO `judgeques` VALUES ('430', '1', '1', '3', '9', '一个对象只能属于一个具体类。', '5', 'y', '0', '2103期末考题');
INSERT INTO `judgeques` VALUES ('431', '1', '1', '3', '9', '一个类只能有一个析构函数，析构函数没有参数，可以重载。', '5', 'n', '0', '2104期末考题');
INSERT INTO `judgeques` VALUES ('432', '1', '1', '3', '9', '用delete和free为对象动态释放内存时，都会自动调用对象的析构函数。', '5', 'n', '0', '2105期末考题');
INSERT INTO `judgeques` VALUES ('433', '1', '1', '3', '9', '用new和malloc为对象动态分配内存时，都会自动调用对象的构造函数。', '5', 'n', '0', '2106期末考题');
INSERT INTO `judgeques` VALUES ('434', '1', '1', '3', '9', '用sizeof计算得到的结构体变量的内存大小一定等于结构体成员占用的内存大小之和。', '5', 'n', '0', '2107期末考题');
INSERT INTO `judgeques` VALUES ('435', '1', '1', '3', '9', '由class定义的抽象数据类型的成员访问限制默认为private。', '5', 'y', '0', '2108期末考题');
INSERT INTO `judgeques` VALUES ('436', '1', '1', '3', '9', '在程序中，一个对象的构造函数只能调用一次。', '5', 'n', '0', '2109期末考题');
INSERT INTO `judgeques` VALUES ('437', '1', '1', '3', '9', '在建立对象前，就可以为静态数据成员赋值。', '5', 'y', '0', '2110期末考题');
INSERT INTO `judgeques` VALUES ('438', '1', '1', '3', '9', '只有私有成员函数才能访问私有成员数据。', '5', 'n', '0', '2111期末考题');
INSERT INTO `judgeques` VALUES ('439', '1', '1', '3', '9', '属性描述对象的数据特征，操作描述对象的行为特征。', '5', 'y', '0', '2112期末考题');
INSERT INTO `judgeques` VALUES ('440', '1', '1', '3', '9', 'cin和cout是C++中用于处理数据输入和输出的两个函数。', '5', 'n', '0', '2113期末考题');
INSERT INTO `judgeques` VALUES ('441', '1', '1', '3', '9', '进行文件读写时，可用fstream类的对象代替ifstream类或ofstream类的对象。', '5', 'y', '0', '2114期末考题');
INSERT INTO `judgeques` VALUES ('442', '1', '1', '3', '9', '当程序中同时出现函数模板template<class T>T max(T a, T b)和重载函数const char * max(const char *a, const char *b)时，则代码max(“abc”, “def”)将优先调用重载函数。', '5', 'y', '0', '2115期末考题');
INSERT INTO `judgeques` VALUES ('443', '1', '1', '3', '9', '函数模板和类模板属于参数多态性。', '5', 'y', '0', '2116期末考题');
INSERT INTO `judgeques` VALUES ('444', '1', '1', '3', '9', '类模板的类型参数只能用class关键字进行声明。', '5', 'n', '0', '2117期末考题');
INSERT INTO `judgeques` VALUES ('445', '1', '1', '3', '9', '类模板的模板参数表也可使用默认参数，例如template <class T>可以写成template<class T=int>。', '5', 'y', '0', '2118期末考题');
INSERT INTO `judgeques` VALUES ('446', '1', '1', '3', '9', '模板支持泛型程序设计，便于实现通用算法和通用数据结构。', '5', 'y', '0', '2119期末考题');
INSERT INTO `judgeques` VALUES ('447', '1', '1', '3', '9', '在声明类模板的指针或引用时也会引起类模板的实例化。', '5', 'n', '0', '2120期末考题');
INSERT INTO `judgeques` VALUES ('448', '1', '1', '3', '9', '由struct定义的抽象数据类型的成员访问限制默认为private。', '5', 'n', '0', '2121期末考题');
INSERT INTO `judgeques` VALUES ('449', '1', '1', '3', '9', '友元关系是一个类的成员函数与另一个类的关系。', '5', 'n', '0', '2122期末考题');
INSERT INTO `judgeques` VALUES ('450', '1', '1', '3', '9', '友元函数破坏了类的封装性。', '5', 'y', '0', '2123期末考题');
INSERT INTO `judgeques` VALUES ('451', '1', '1', '3', '9', '友元函数是类的成员函数。 ', '3', 'n', '0', '2124期末考题');
INSERT INTO `judgeques` VALUES ('452', '1', '1', '3', '9', '友元函数属于类的成员函数，可以访问类中的其它成员。', '3', 'n', '0', '2125期末考题');
INSERT INTO `judgeques` VALUES ('453', '1', '1', '3', '9', '友元破坏了类的封装性。', '3', 'y', '0', '2126期末考题');
INSERT INTO `judgeques` VALUES ('454', '1', '1', '3', '9', '使用C风格字符串处理函数时，需要包含标准库的头文件<string>', '3', 'n', '0', '2127期末考题');

-- ----------------------------
-- Table structure for knowledge
-- ----------------------------
DROP TABLE IF EXISTS `knowledge`;
CREATE TABLE `knowledge` (
  `k_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_id` int(11) DEFAULT NULL,
  `knowledgeName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`k_id`),
  KEY `c_id` (`c_id`),
  KEY `k_id` (`k_id`),
  CONSTRAINT `knowledge_ibfk_1` FOREIGN KEY (`c_id`) REFERENCES `course` (`c_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of knowledge
-- ----------------------------
INSERT INTO `knowledge` VALUES ('1', '1', '面向对象');
INSERT INTO `knowledge` VALUES ('2', '1', '类和继承');
INSERT INTO `knowledge` VALUES ('3', '2', '电与磁');
INSERT INTO `knowledge` VALUES ('4', '2', '光学基础');
INSERT INTO `knowledge` VALUES ('5', '3', '新视野第三版');
INSERT INTO `knowledge` VALUES ('6', '3', '新视野第四版');
INSERT INTO `knowledge` VALUES ('7', '1', '封装与多态');

-- ----------------------------
-- Table structure for knowledgetemplet
-- ----------------------------
DROP TABLE IF EXISTS `knowledgetemplet`;
CREATE TABLE `knowledgetemplet` (
  `kt_id` int(11) NOT NULL AUTO_INCREMENT,
  `pt_id` int(11) DEFAULT NULL,
  `k_id` int(11) DEFAULT NULL,
  `judgeQuesNum` int(11) DEFAULT NULL,
  `selectQuesNum` int(11) DEFAULT NULL,
  `fillBlankQuesNum` int(11) DEFAULT NULL,
  `bigQuesNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`kt_id`),
  KEY `k_id` (`k_id`),
  KEY `pt_id` (`pt_id`),
  CONSTRAINT `knowledgetemplet_ibfk_1` FOREIGN KEY (`k_id`) REFERENCES `knowledge` (`k_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `knowledgetemplet_ibfk_2` FOREIGN KEY (`pt_id`) REFERENCES `papertemplet` (`pt_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of knowledgetemplet
-- ----------------------------
INSERT INTO `knowledgetemplet` VALUES ('11', '6', '1', '5', '5', '5', '1');
INSERT INTO `knowledgetemplet` VALUES ('12', '6', '2', '5', '10', '5', '0');

-- ----------------------------
-- Table structure for paper
-- ----------------------------
DROP TABLE IF EXISTS `paper`;
CREATE TABLE `paper` (
  `pa_id` int(11) NOT NULL AUTO_INCREMENT,
  `path` varchar(255) DEFAULT NULL,
  `paperName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pa_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of paper
-- ----------------------------
INSERT INTO `paper` VALUES ('1', 'papers/rtr.doc', 'rtr');
INSERT INTO `paper` VALUES ('2', 'papers/zcx.doc', 'zcx');
INSERT INTO `paper` VALUES ('3', 'papers/实施中文.doc', '实施中文');
INSERT INTO `paper` VALUES ('4', 'papers/hfhfh.doc', 'hfhfh');
INSERT INTO `paper` VALUES ('5', 'papers/demo.doc', 'demo');
INSERT INTO `paper` VALUES ('6', 'papers/demo.doc', 'demo');
INSERT INTO `paper` VALUES ('7', 'papers/df.doc', 'df');
INSERT INTO `paper` VALUES ('8', 'papers/df.doc', 'df');
INSERT INTO `paper` VALUES ('9', 'papers/dfh.doc', 'dfh');

-- ----------------------------
-- Table structure for papertemplet
-- ----------------------------
DROP TABLE IF EXISTS `papertemplet`;
CREATE TABLE `papertemplet` (
  `pt_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_id` int(11) DEFAULT NULL,
  `templetName` varchar(255) DEFAULT NULL,
  `difficultyLevel` int(11) DEFAULT NULL,
  `score` int(5) DEFAULT NULL,
  `judgeQuesNum` int(11) DEFAULT NULL,
  `selectQuesNum` int(11) DEFAULT NULL,
  `bigQuesNum` int(11) DEFAULT NULL,
  `fillBlankQuesNum` int(11) DEFAULT NULL,
  `judgeQuesScore` int(11) DEFAULT NULL,
  `selectQuesScore` int(11) DEFAULT NULL,
  `bigQuesScore` int(11) DEFAULT NULL,
  `fillBlankQuesScore` int(11) DEFAULT NULL,
  PRIMARY KEY (`pt_id`),
  KEY `c_id` (`c_id`),
  CONSTRAINT `papertemplet_ibfk_1` FOREIGN KEY (`c_id`) REFERENCES `course` (`c_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of papertemplet
-- ----------------------------
INSERT INTO `papertemplet` VALUES ('6', '1', 'java普通模板', '3', '100', '10', '15', '1', '10', '1', '3', '15', '3');

-- ----------------------------
-- Table structure for probcate
-- ----------------------------
DROP TABLE IF EXISTS `probcate`;
CREATE TABLE `probcate` (
  `p_id` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of probcate
-- ----------------------------
INSERT INTO `probcate` VALUES ('1', '选择题');
INSERT INTO `probcate` VALUES ('2', '填空题');
INSERT INTO `probcate` VALUES ('3', '判断题');
INSERT INTO `probcate` VALUES ('4', '大题');

-- ----------------------------
-- Table structure for quescate
-- ----------------------------
DROP TABLE IF EXISTS `quescate`;
CREATE TABLE `quescate` (
  `q_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_id` int(11) DEFAULT NULL,
  `qcName` varchar(255) DEFAULT NULL,
  `p_id` int(11) DEFAULT NULL,
  `BlankNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`q_id`),
  KEY `c_id` (`c_id`),
  KEY `p_id` (`p_id`),
  CONSTRAINT `quescate_ibfk_1` FOREIGN KEY (`c_id`) REFERENCES `course` (`c_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `quescate_ibfk_2` FOREIGN KEY (`p_id`) REFERENCES `probcate` (`p_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of quescate
-- ----------------------------
INSERT INTO `quescate` VALUES ('4', '1', '程序分析填空', '2', '2');
INSERT INTO `quescate` VALUES ('5', '1', '程序设计', '4', '3');
INSERT INTO `quescate` VALUES ('6', '2', '公式填空', '2', '4');
INSERT INTO `quescate` VALUES ('7', '2', '定理填空', '2', '4');
INSERT INTO `quescate` VALUES ('8', '3', '单词选择', '1', '4');
INSERT INTO `quescate` VALUES ('9', '1', '代码判断', '3', '1');
INSERT INTO `quescate` VALUES ('10', '1', '普通选择', '1', '4');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `r_id` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`r_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'teacher');
INSERT INTO `role` VALUES ('2', 'manager');

-- ----------------------------
-- Table structure for selectques
-- ----------------------------
DROP TABLE IF EXISTS `selectques`;
CREATE TABLE `selectques` (
  `s_id` int(255) NOT NULL AUTO_INCREMENT,
  `k_id` int(11) DEFAULT NULL,
  `c_id` int(11) DEFAULT NULL,
  `p_id` int(11) DEFAULT '1',
  `qc_id` int(11) DEFAULT NULL,
  `title` varchar(2000) DEFAULT NULL,
  `option` varchar(500) DEFAULT NULL,
  `difficultyLevel` int(11) DEFAULT NULL,
  `answer` varchar(255) DEFAULT NULL,
  `selectedNum` int(11) DEFAULT '0',
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`s_id`),
  KEY `qc_id` (`qc_id`),
  KEY `k_id` (`k_id`),
  KEY `c_id` (`c_id`),
  KEY `p_id` (`p_id`),
  CONSTRAINT `selectques_ibfk_1` FOREIGN KEY (`qc_id`) REFERENCES `quescate` (`q_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `selectques_ibfk_2` FOREIGN KEY (`k_id`) REFERENCES `knowledge` (`k_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `selectques_ibfk_3` FOREIGN KEY (`c_id`) REFERENCES `course` (`c_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `selectques_ibfk_4` FOREIGN KEY (`p_id`) REFERENCES `probcate` (`p_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=167 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of selectques
-- ----------------------------
INSERT INTO `selectques` VALUES ('86', '1', '1', '1', '10', '下列哪个标准类模板不能使用通用算法algorithm中定义的sort算法', '###vector###list###deque###string', '1', 'B', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('87', '1', '1', '1', '10', '抽象类应含有(    )。', '###至少一个虚函数###至多一个虚函数###至少一个纯虚函数 ###至多一个纯虚函数', '1', 'C', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('88', '1', '1', '1', '10', '实现运行时的多态性要使用(    )。', '###重载函数###构造函数###析构函数###虚函数', '1', 'D', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('89', '1', '1', '1', '10', '以下基类中的成员函数, 哪个表示纯虚函数(    )。', '###virtual void vf(int)###void vf(int )=0###virtual void vf()=0###virtual void yf(int){}', '1', 'C', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('90', '1', '1', '1', '10', '在C++中，要实现动态联编，必须使用(    )调用虚函数。', '###类名###派生类指针###对象名###基类指针或引用', '1', 'D', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('91', '1', '1', '1', '10', '在派生类中，重载一个虚函数时，要求函数名、参数个数、参数的类型、参数的顺序和函数的返回值类型(    )。', '###不同###相同###相容###部分相同', '1', 'B', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('92', '1', '1', '1', '10', '关于运算符重载的正确描述是(    )。  ', '###运算符的优先级可以改变###运算符的结合性可以改变###运算符的功能可以改变###运算符的操作数个数可以改变', '1', 'C', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('93', '1', '1', '1', '10', '能用友元函数重载的运算符是(    )。', '###+###->###[]###=', '1', 'A', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('94', '1', '1', '1', '10', '下列运算符中，不能重载的是(    )。', '###::###+###- ###+=', '1', 'A', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('95', '1', '1', '1', '10', '下列运算符中，不能重载的是(    )。', '###&&###[ ]###::###new', '2', 'C', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('96', '1', '1', '1', '10', '使用重载函数编程序的目的是(    )。', '###使用相同的函数名调用功能相似的函数###共享程序代码###提高程序的运行速度###节省存储空间', '2', 'A', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('97', '1', '1', '1', '10', '与C语言相比，C++在求解问题方法上进行的最大改进是(    )。', '###面向过程###面向对象###安全性###可移植性', '2', 'B', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('98', '1', '1', '1', '10', 'C++源文件的扩展名通常为(    )。', '### .h### .c### .cpp### .cs', '2', 'C', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('99', '1', '1', '1', '10', '基于面向对象程序设计的软件系统应该具有(    )。', '###高内聚、高耦合的特征###高内聚、低耦合的特征###低内聚、高耦合的特征###低内聚、低耦合的特征', '2', 'B', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('100', '1', '1', '1', '10', '假定Matrix是名称空间osg的一个类，则下列语句错误的是(    )。', '###using namespace osg; Matrix m;###using osg::Matrix; Matrix m;###osg::Matrix m;###using namespace osg::Matrix; Matrix m;', '2', 'D', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('101', '1', '1', '1', '10', '面向对象程序设计将描述事物的数据与(    )封装在一起，作为一个相互依存、不可分割的整体来处理。', '###数据抽象###数据隐藏###对数据的操作###信息', '2', 'C', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('102', '1', '1', '1', '10', '如果声明了const int *p，则(    )。', '###p指针初始化后不能再次指向其它地址###不能修改p指针指向的内容###可以修改p指针及其指向的内容###不能修改p指针及其指向的内容', '2', 'B', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('103', '1', '1', '1', '10', '为了取代C中带参数的宏，在C++中使用(    )。', '###递归函数###友元函数###重载函数###内联函数', '2', 'D', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('104', '1', '1', '1', '10', '为提高程序效率，对于功能简单且需频繁调用的函数需使用(    )。', '###内联函数###重载函数###递归函数###函数模板', '2', 'A', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('105', '1', '1', '1', '10', '下列不支持面向对象程序设计的语言是(    )。', '###C++###C###Java###Smalltalk', '2', 'B', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('106', '1', '1', '1', '10', '下列不属于面向对象技术的基本特征的是(    )。', '###封装性###继承性###多态性###模块性', '2', 'D', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('107', '1', '1', '1', '10', '下列关于const修饰指针的用法中，正确的是(    )。', '###int x = 3, y = 5;\nconst int *p = &x;\n*p = 7;###int x = 3, y = 5;\nconst int *p = &x;\np = &y;###int x = 3, y = 5;\nconst int* const p = &x;\np = &y;###int x = 3, y = 5;\nint* const p = &x;\np = &y;', '2', 'B', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('108', '1', '1', '1', '10', '下列关于名字空间的用法中，错误的是(    )。', '###using namespace std;###using std::cin;###using namespace std::cout;###std::cout << \"Hello.\\n\";', '2', 'C', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('109', '1', '1', '1', '10', '下列关于引用的描述中，错误的是(    )。', '###引用是被引对象或变量的别名###引用初始化需要使用被引对象或变量的地址###引用定义时必须初始化###引用可以用作形参和返回值', '2', 'B', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('110', '1', '1', '1', '10', '下列关于引用的用法中，正确的是(    )。', '###int x = 100; int &refx = x;###int x = 100; int &refx = &x;###int &refx = 100;###int x = 100, &refx; refx = x;', '2', 'A', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('111', '1', '1', '1', '10', '下列哪个函数不能实现两个数的交换(    )。', '###void Swap1(int &x, int &y)\n{\n int t = x;\n x = y;\n y = t;\n}###void Swap2(int *x, int *y)\n{\n int t = *x;\n *x = *y;\n *y = t;\n}###void Swap3(int* &x, int* &y)\n{\n int t = *x;\n *x = *y;\n *y = t;\n}###void Swap4(int &x, int &y)\n{\n int &t = x;\n x = y;\n y = t;\n}', '2', 'D', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('112', '1', '1', '1', '10', '下面概念中，不属于面向对象编程方法的是(    )。', '###对象###继承###类###过程调用', '2', 'D', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('113', '1', '1', '1', '10', '下面关于类和对象的说法中，错误的是(    )。', '###对象是类的一个实例。###任何一个对象只能属于一个具体类###一个类只能有一个对象###类与对象的关系同数据类型与变量的关系相似', '2', 'C', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('114', '1', '1', '1', '10', '在C++程序中，对象之间的相互通信通过(    )。', '###继承实现###调用成员函数实现###封装实现###函数重载实现', '2', 'B', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('115', '1', '1', '1', '10', '在下列关于C++函数的描述中，正确的是(    )', '###每个函数至少要有一个参数###每个函数都必须返回一个值###函数在被调用之前必须先声明###函数不能自己调用自己', '3', 'C', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('116', '1', '1', '1', '10', '在一下哪种情况下适宜采用inline定义内联函数(    )。', '###函数体含有循环语句###函数体含有递归语句###函数代码小，频繁调用###函数代码多，不常调用', '3', 'C', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('117', '1', '1', '1', '10', '当保护继承时，基类的哪些成员将成为派生类的保护成员，不能通过派生类的对象来直接访问(    )。', '###公有成员和保护成员###任何成员###公有成员和私有成员###私有成员', '3', 'A', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('118', '1', '1', '1', '10', '派生类的对象对它的基类成员中(    )是可以访问的。', '###公有继承的公有成员###公有继承的私有成员###公有继承的保护成员###私有继承的公有成员', '3', 'A', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('119', '1', '1', '1', '10', '通过(    )可以在现有类的基础上派生出新的类。', '###包含###继承###封装###引用', '3', 'B', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('120', '1', '1', '1', '10', '下列不能在构造函数的初始化列表中初始化的是(    )。', '###对象成员###基类数据成员###const数据成员###static数据成员', '3', 'D', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('121', '1', '1', '1', '10', '下列对派生类的描述中错误的说法是(    )。', '###派生类至少有一个基类###派生类可作为另一个派生类的基类###派生类除了包含它直接定义的成员外，还包含其基类的成员###派生类所继承的基类成员的访问权限保持不变', '3', 'D', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('122', '1', '1', '1', '10', '在定义一个派生类时，若不使用保留字显式地规定采用何种继承方式，则默认为(    )方式。', '###私有继承###非私有继承###保护继承###公有继承', '3', 'A', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('123', '1', '1', '1', '10', '在派生类构造函数的初始化列表中一般不需要包含(    )。', '###基类的构造函数 ###基类的对象成员的初始化###派生类对象成员的初始化###派生类中一般数据成员的初始化', '3', 'D', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('124', '1', '1', '1', '10', '不属于类的成员函数的是(    )。', '###静态成员函数###友元函数###构造函数###析构函数', '3', 'B', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('125', '1', '1', '1', '10', '对于任意一个类，析构函数的个数最多为(    )。', '###0.0###1.0###2.0###3.0', '3', 'B', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('126', '1', '1', '1', '10', '构造函数在(    )时被执行。', '###程序装入内存###创建类###创建对象###程序编译', '3', 'C', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('127', '1', '1', '1', '10', '假定AB为一个类，则该类的拷贝构造函数的声明语句为(    )。', '###AB&(AB x)###AB(AB x)###AB(AB &)###AB(AB * x)', '3', 'C', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('128', '1', '1', '1', '10', '假定一个类的构造函数为 “A(int aa, int bb) {a=aa; b=aa*bb;}”，则执行 “A x = new A(4,5);”语句后，a 和 b 的值分别为(    )。', '###4和5###5和4 ###4和20 ###20和5', '3', 'C', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('129', '1', '1', '1', '10', '假设class A为一个类，则执行＂A x;＂语句时将自动调用该类的(    )。', '###无参构造函数 ###带参构造函数###复制构造函数###重载的赋值运算符', '3', 'A', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('130', '1', '1', '1', '10', '静态成员函数没有(    )。', '###指针参数###返回值###返回类型###this指针', '3', 'D', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('131', '1', '1', '1', '10', '聚合与组合都描述组成关系，相比而言，(    )。', '###聚合更松散###组合更松散###聚合与组合一样松散###聚合与组合的松散程度无法比较', '4', 'A', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('132', '1', '1', '1', '10', '拷贝构造函数的参数通常是(    )。', '###某个对象的地址###某个对象的成员###某个对象的引用###某个对象的指针', '4', 'C', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('133', '1', '1', '1', '10', '可以用P.a的形式访问派生类对象P的基类成员a，其中a 是(    )。', '###公有继承的私有成员###公有继承的保护成员###公有继承的公有成员###私有继承的公有成员', '4', 'C', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('134', '1', '1', '1', '10', '类的构造函数是在定义该类的一个(    )时被自动调用执行的。', '###数据成员###对象###成员函数###友元函数', '4', 'B', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('135', '1', '1', '1', '10', '类的实例化是指(    )。', '###定义类###创建类的对象###指明具体类###调用类的成员', '4', 'B', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('136', '1', '1', '1', '10', '如果要禁止对象之间的赋值运算，应该把operator=声明为(    )成员。', '###public###private###protected###friend', '4', 'B', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('137', '1', '1', '1', '10', '下列关于this指针的描述错误的是(    )。', '###调用非静态成员函数时，隐含的this指针指向调用它的对象###调用静态成员函数时，隐含的this指针指向调用它的对象###类的静态成员函数不具有隐含的this指针###类的友元函数不具有隐含的this指针', '4', 'B', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('138', '1', '1', '1', '10', '下列关于成员函数的描述中，错误的是(    )。', '###成员函数一定是内联函数###成员函数可以重载###成员函数可以设置缺省参数值###成员函数可以是静态的', '4', 'A', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('139', '1', '1', '1', '10', '下列关于构造函数的描述正确的是(    )。', '###构造函数可以声明返回类型###构造函数不可以用private修饰###构造函数必须与类名相同###构造函数不能带参数', '4', 'C', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('140', '1', '1', '1', '10', '下列关于构造函数的描述中，错误的是(    )。', '###构造函数与类同名###构造函数具有返回值类型###构造函数可以重载###构造函数可以带有默认参数', '4', 'B', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('141', '1', '1', '1', '10', '下列关于构造函数和析构函数的描述正确的是(    )。', '###构造函数和析构函数都没有返回值###构造函数和析构函数都可以重载###构造函数和析构函数都不能被继承###析构函数可以定义为虚函数', '4', 'D', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('142', '1', '1', '1', '10', '下列关于类的保护成员的描述中，错误的是(    )。', '###可以被类中的成员函数访问###可以被类的友元访问###可以被派生类中的成员访问###可以被全局函数访问', '4', 'D', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('143', '1', '1', '1', '10', '下列关于析构函数的正确描述是(    )。', '###析构函数可以具有参数###析构函数可以定义为虚函数###析构函数可以被重载###析构函数具有返回值', '4', 'B', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('144', '1', '1', '1', '10', '下列哪个操作不会调用拷贝构造函数(    )。', '###基于一个现有对象构造另一个同类对象###函数调用时按值传递对象###函数调用时按值返回对象###函数调用时按引用传递对象', '4', 'D', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('145', '1', '1', '1', '10', '已知S和T为string类对象，下列表达式错误的是(    )。', '###S=T;###S == T###S-=T;###S+=T;', '4', 'C', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('146', '1', '1', '1', '10', '在下面选项中，对类的拷贝构造函数的声明形式是(    )。', '###A::A(&)###A::A(constA&)###A::A(A)###void A::A(A&a)', '4', 'D', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('147', '1', '1', '1', '10', 'C++标准库中的输入输出流的头文件为(    )。', '###stdafx.h  ###string###iostream ###stdio', '4', 'C', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('148', '1', '1', '1', '10', 'cin是iostream中的(    )。', '###一个标准语句###预定义的类###预定义的函数###预定义的对象', '5', 'D', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('149', '1', '1', '1', '10', '当用输出文件流对象调用open成员函数打开一个文件时，打开方式参数也可以省略，缺省按(    )方式打开。', '###ios_base::in###ios_base::out###ios_base::trunc###ios_base::binary', '5', 'B', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('150', '1', '1', '1', '10', '关于ostringstream类的错误描述是(    )。', '###可实现与C语言的sprinf函数类似的操作###可将整数或浮点数转换为字符串###可将字符串转换为整数或浮点数###父类是istream类', '5', 'C', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('151', '1', '1', '1', '10', '若需要以只读方式打开一个二进制文件”a.bin”，正确的操作为(    )。', '###ifstream myFile(\"a.bin\");###ofstream myFile(\"a.bin\", ios::binary);###fstream myFile(\"a.bin\", ios::out|ios::binary);###fstream myFile(\"a.bin\", ios::in|ios::binary);', '5', 'D', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('152', '1', '1', '1', '10', '若要打开一个用于输入的文本文件file.txt，下列操作错误的是(    )。', '###ifstream inFile(\"file.txt\");###ifstream inFile; inFile.open(\"file.txt\");###fstream inFile(\"file.txt\", ios::in);###fstream inFile(\"file.txt\", ios::binary);', '5', 'D', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('153', '1', '1', '1', '10', '若要将一个字符串“12345”转化为数值12345，错误的操作是(    )。', '###int nVal=(int)atof(\"12345\");###int nVal=atoi(\"12345\");###int val; istringstream inS(\"12345\"); inS >> val;###ostringstream outS(\"12345\"); outS << val;', '5', 'D', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('154', '1', '1', '1', '10', '下面不能读取空格符号的istream类成员函数为', '###>>运算符重载函数###get()函数###get(char)函数###getline()函数', '5', 'A', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('155', '1', '1', '1', '10', '要进行文件的输出，除了包含头文件iostream外，还要包含头文件(    )。', '###ifstream###fstream###ostream###cstdio', '5', 'B', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('156', '1', '1', '1', '10', '若同时定义了如下函数，fun(\'A\', 85)调用的是下列哪个函数(    )。', '###template <class T1, class T2>void fun(T1, T2)###void fun(double, int)###void fun(char, float)###void fun(double, double)', '5', 'A', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('157', '1', '1', '1', '10', '下列关于函数模板的描述错误的是(    )。', '###函数模板需要实例化后才能执行###函数模板可以重载###函数模板的模板参数具有隐式类型转换功能###编译时，同名的重载函数优先于函数模板', '5', 'C', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('158', '1', '1', '1', '10', '以下类模板template <class T1, class T2=int, int num=10>class MyClass{…};正确的实例化方式是(    )。', '###MyClass <char , char> C1;###MyClass <char *, ,100 > C1;###MyClass <> C1;###MyClass <char, 100, int> C1;', '5', 'A', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('159', '1', '1', '1', '10', '有如下函数模板：template <class T> T square(T x){return x*x;}，其中T是(    )。', '###函数形参###函数实参###模板形参###模板实参', '5', 'C', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('160', '1', '1', '1', '10', '类模板定义中的模板参数(    )。', '###可以有多个###不能有基本数据类型###可以是0个###不能有默认参数', '5', 'A', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('161', '1', '1', '1', '10', '类模板的实例化(    )。', '###在编译时进行###属于动态联编###在运行时进行###在连接时进行', '5', 'A', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('162', '1', '1', '1', '10', '使用模板的主要目的是为了(    )。', '###提高代码的可重用性###提高代码的运行效率###加强类的封装性###实现多态性', '5', 'A', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('163', '1', '1', '1', '10', '引入友元的主要目的是为了(    )。', '###增强数据安全性 ###提高程序的可靠性###提高程序的效率和灵活性  ###保证类的封装性', '5', 'C', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('164', '1', '1', '1', '10', '下列关于友元的描述中，正确的是(    )。', '###友元关系具有传递性###友元关系具有对称性###友元关系具有继承性###类A的友元类B的成员函数均是类A的友元函数', '5', 'D', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('165', '1', '1', '1', '10', '一个类的友元函数或友元类能够通过成员操作符访问该类的(    )。', '###私有成员###保护成员###公有成员###所有成员', '5', 'D', '0', '测试选择题');
INSERT INTO `selectques` VALUES ('166', '1', '1', '1', '10', '已知类A是类B的友元，类B是类C的友元，则(  )。', '###类A一定是类C的友元###类A的成员函数可以访问类B的对象的任何成员###类C的成员函数可以访问类B的对象的任何成员### 类C一定是类A的友元', '3', 'B', '0', '测试选择题');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `r_id` int(11) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`u_id`),
  KEY `r_id` (`r_id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`r_id`) REFERENCES `role` (`r_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('19', '2', 'admin', 'ISMvKXpXpadDiUoOSoAfww==', '默认管理员');
