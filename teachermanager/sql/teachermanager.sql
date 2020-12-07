/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50617
 Source Host           : localhost:3306
 Source Schema         : teachermanager

 Target Server Type    : MySQL
 Target Server Version : 50617
 File Encoding         : 65001

 Date: 07/12/2020 23:59:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录账号（即教工编号）',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录密码',
  `name` varchar(14) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '真实姓名',
  `sex` int(10) NOT NULL DEFAULT 0 COMMENT '性别',
  `title` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职称',
  `telephone` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `is_deleted` int(10) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理员表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('string', 'string', 'string', 0, 'string', 'string', 0, '2020-11-20 23:54:22', '2020-11-20 23:54:22');

-- ----------------------------
-- Table structure for classes
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes`  (
  `id` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '班级编号',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '班级名称',
  `number` int(11) NULL DEFAULT NULL COMMENT '班级人数',
  `headmaster` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '班主任名称',
  `is_new_major` int(10) NULL DEFAULT NULL COMMENT '是否为新增专业班级，0为false，1为true',
  `is_deleted` int(10) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '班级表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of classes
-- ----------------------------
INSERT INTO `classes` VALUES ('1332566964022886401', NULL, 30, NULL, 0, 1, '2020-11-28 14:08:17', '2020-11-28 14:08:17');
INSERT INTO `classes` VALUES ('1332570526643732481', '计算机17-2', 30, '规划计划通过', 1, 0, '2020-11-28 14:22:26', '2020-11-28 14:22:26');
INSERT INTO `classes` VALUES ('1332581616777814018', '计算机17-2', 30, '额外若翁', 0, 0, '2020-11-28 15:06:30', '2020-11-28 15:06:30');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `term` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学年学期',
  `id` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程编号',
  `course_type_id` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用于识别课程类型',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程名称',
  `class_time` int(10) NULL DEFAULT NULL COMMENT '总学时',
  `theory_class_time` int(10) NULL DEFAULT NULL COMMENT '理论课学时',
  `experimental_class_time` int(10) NULL DEFAULT NULL COMMENT '实验课学时',
  `weeks` int(10) NULL DEFAULT NULL COMMENT '计划周数',
  `class_number` int(10) NULL DEFAULT NULL COMMENT '教班数量',
  `student_number` int(10) NULL DEFAULT NULL COMMENT '排课人数',
  `guide_inspect_frequency` int(10) NULL DEFAULT NULL COMMENT '指导/考察次数（用于确认课程设计、实训、实习的课程系数）',
  `teacher_id` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '授课教师编号（用于获取teacher表的教师名）',
  `is_new` int(10) NULL DEFAULT 1 COMMENT '是否为“开新课/新开课”',
  `is_xicheng` int(10) NULL DEFAULT 1 COMMENT '是否在西城校区教学',
  `is_deleted` int(10) NOT NULL DEFAULT 0 COMMENT '逻辑删除，1（true）已删除，0（false）未删除',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '课程信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('string', '1332344328479162369', 'string', 'string', 0, 0, 0, 0, 0, 0, NULL, 'string', 0, 0, 1, '2020-11-27 23:23:36', '2020-11-27 23:23:36');
INSERT INTO `course` VALUES ('string', '1332344383722340353', 'string', 'string', 0, 0, 0, 0, 0, 0, NULL, 'string', 0, 0, 1, '2020-11-27 23:23:50', '2020-11-27 23:23:50');
INSERT INTO `course` VALUES ('string', '1332344393184690177', 'string', 'string', 0, 0, 0, 0, 0, 0, NULL, 'string', 0, 0, 0, '2020-11-27 23:23:52', '2020-11-27 23:23:52');
INSERT INTO `course` VALUES ('string', '1332344404534476802', 'string', 'string', 0, 0, 0, 0, 0, 0, NULL, 'string', 0, 0, 0, '2020-11-27 23:23:54', '2020-11-27 23:23:54');
INSERT INTO `course` VALUES ('是的', '1332503038648147969', '实践教学', 'ARASHI', 1, 1, 1, 1, 1, 1, NULL, '规划计划通过', 0, 1, 0, '2020-11-28 09:54:16', '2020-11-28 09:54:16');
INSERT INTO `course` VALUES ('地方', '1332503404395651074', '1332343823573041154', '大杀特杀', 1, 1, 1, 1, 1, 1, 1, '1334884261362167809', 0, 1, 0, '2020-11-28 09:55:43', '2020-11-28 09:55:43');
INSERT INTO `course` VALUES (NULL, '1332516143889408001', '1332343992507023362', 'ggfchdf ', 1, 1, 1, 1, 1, 1, 1, '1330068033888169985', 1, 0, 0, '2020-11-28 10:46:20', '2020-11-28 10:46:20');

-- ----------------------------
-- Table structure for course_type
-- ----------------------------
DROP TABLE IF EXISTS `course_type`;
CREATE TABLE `course_type`  (
  `id` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程类型编号',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程名称',
  `is_deleted` int(10) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '课程类型表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of course_type
-- ----------------------------
INSERT INTO `course_type` VALUES ('1332343823573041154', '课堂教学', 0, '2020-11-27 23:21:36', '2020-11-27 23:21:36');
INSERT INTO `course_type` VALUES ('1332343992507023362', '实践教学', 0, '2020-11-27 23:22:16', '2020-11-27 23:22:16');
INSERT INTO `course_type` VALUES ('1332344092541173761', '考试工作量', 0, '2020-11-27 23:22:40', '2020-11-27 23:22:40');

-- ----------------------------
-- Table structure for parameter
-- ----------------------------
DROP TABLE IF EXISTS `parameter`;
CREATE TABLE `parameter`  (
  `id` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `single_class` float(10, 2) NULL DEFAULT NULL COMMENT '单班课合班系数',
  `double_class` float(10, 2) NULL DEFAULT NULL COMMENT '双班课合班系数',
  `three_class` float(10, 2) NULL DEFAULT NULL COMMENT '三班课合班系数',
  `four_class` float(10, 2) NULL DEFAULT NULL COMMENT '四班课及以上合班系数',
  `repeat_course` float(10, 2) NULL DEFAULT NULL COMMENT '重复班课合班系数（用于第二个教学大班的计算）',
  `theory_standard_number` int(10) NULL DEFAULT NULL COMMENT '理论课单班标准人数',
  `theory_excess_student` float(10, 2) NULL DEFAULT NULL COMMENT '理论课超额学生合班累加系数',
  `experiment_repeat_course` float(10, 2) NULL DEFAULT NULL COMMENT '实验课重复班课合班系数',
  `experiment_class_batch` float(10, 2) NULL DEFAULT NULL COMMENT '实验课单班分批进行的合班系数',
  `experiment_classes_batch` float(10, 2) NULL DEFAULT NULL COMMENT '实验课多班分批进行的合班系数',
  `operation_repeat_double_class` float(10, 2) NULL DEFAULT NULL COMMENT '上机课重复课双班合班系数（每次上机两个班）',
  `new_course` float(10, 2) NULL DEFAULT NULL COMMENT '开新课/新开课',
  `xicheng_course` float(10, 2) NULL DEFAULT NULL COMMENT '在西城校区开设的课程',
  `grade13` float(10, 2) NULL DEFAULT NULL COMMENT '13级教师岗位系数',
  `grade12` float(10, 2) NULL DEFAULT NULL COMMENT '12级教师岗位系数',
  `grade11` float(10, 2) NULL DEFAULT NULL COMMENT '11级教师岗位系数',
  `grade10` float(10, 2) NULL DEFAULT NULL COMMENT '10级教师岗位系数',
  `grade9` float(10, 2) NULL DEFAULT NULL COMMENT '9级教师岗位系数',
  `grade8` float(10, 2) NULL DEFAULT NULL COMMENT '8级教师岗位系数',
  `grade7` float(10, 2) NULL DEFAULT NULL COMMENT '7级教师岗位系数',
  `grade6` float(10, 2) NULL DEFAULT NULL COMMENT '6级教师岗位系数',
  `grade5` float(10, 2) NULL DEFAULT NULL COMMENT '5级教师岗位系数',
  `grade4` float(10, 2) NULL DEFAULT NULL COMMENT '4级教师岗位系数',
  `grade3` float(10, 2) NULL DEFAULT NULL COMMENT '3级教师岗位系数',
  `grade2` float(10, 2) NULL DEFAULT NULL COMMENT '2级教师岗位系数',
  `practice_guidance1_time` int(10) NULL DEFAULT NULL COMMENT '校内指导学时（课程设计、实训、认识/毕业/专业实习）',
  `practice_guidance1_course1` float(10, 2) NULL DEFAULT NULL COMMENT '校内指导课程系数1（每周集体指导至少5次）',
  `practice_guidance1_course2` float(10, 2) NULL DEFAULT NULL COMMENT '校内指导课程系数2【每周2次（含2次）以下理论指导或集体指导】',
  `practice_guidance2_time` int(10) NULL DEFAULT NULL COMMENT '校外指导实习学时',
  `practice_guidance2_course` float(10, 2) NULL DEFAULT NULL COMMENT '校外指导实习课程系数',
  `external_practice_contact_time` int(10) NULL DEFAULT NULL COMMENT '校外实习联系学时',
  `external_practice_contact_course1` float(10, 2) NULL DEFAULT NULL COMMENT '校外实习联系课程系数1（参观考察2次/个以上周边企业单位）',
  `external_practice_contact_course2` float(10, 2) NULL DEFAULT NULL COMMENT '校外实习联系课程系数2（参观考察少于2次/个周边企业单位）',
  `dissertation_time` int(10) NULL DEFAULT NULL COMMENT '学生毕业论文（设计）学时/学生',
  `review_time` float(10, 2) NULL DEFAULT NULL COMMENT '评阅论文学时/学生',
  `capstone_presentation_time` float(10, 2) NULL DEFAULT NULL COMMENT '开题答辩学时/学生',
  `interim_defense_time` float(10, 2) NULL DEFAULT NULL COMMENT '中期答辩学时/学生',
  `group_denfense_time` float(10, 2) NULL DEFAULT NULL COMMENT '小组答辩学时/学生',
  `public_denfense_time` float(10, 2) NULL DEFAULT NULL COMMENT '公开答辩学时/学生',
  `denfense_secretary_time` float(10, 2) NULL DEFAULT NULL COMMENT '答辩秘书学时/学生',
  `capstone_course_time` float(10, 2) NULL DEFAULT NULL COMMENT 'Capstone课程学时/学生',
  `establish_test_banks` float(10, 2) NULL DEFAULT NULL COMMENT '首次建立试题库',
  `perfect_test_banks` float(10, 2) NULL DEFAULT NULL COMMENT '补充完善试题库',
  `written_test_proposition` float(10, 2) NULL DEFAULT NULL COMMENT '笔试命题',
  `computer_test_proposition` float(10, 2) NULL DEFAULT NULL COMMENT '机考命题',
  `reading_volumes` float(10, 2) NULL DEFAULT NULL COMMENT '期末考试、各种补考阅卷',
  `invigilator1` float(10, 2) NULL DEFAULT NULL COMMENT '监考1（正常上班期间）',
  `invigilator2` float(10, 2) NULL DEFAULT NULL COMMENT '监考2（下午4：20～6：20）',
  `invigilator3` float(10, 2) NULL DEFAULT NULL COMMENT '监考3（晚上、双休日、寒暑假）',
  `examination1` float(10, 2) NULL DEFAULT NULL COMMENT '考试值班1（下午4：20～6：20）',
  `examination2` float(10, 2) NULL DEFAULT NULL COMMENT '考试值班2（晚上、双休日、寒暑假）',
  `writing_teaching_documents1` float(10, 2) NULL DEFAULT NULL COMMENT '制订新专业人才培养方案',
  `writing_teaching_documents2` float(10, 2) NULL DEFAULT NULL COMMENT '修订专业人才培养方案',
  `writing_teaching_documents3` float(10, 2) NULL DEFAULT NULL COMMENT '按照专业认证标准要求编写课程教学大纲、考试大纲',
  `writing_teaching_documents4` float(10, 2) NULL DEFAULT NULL COMMENT '按照专业认证标准要求修订课程教学大纲、考试大纲',
  `writing_teaching_documents5` float(10, 2) NULL DEFAULT NULL COMMENT '按常规编写课程教学大纲、考试大纲',
  `writing_teaching_documents6` float(10, 2) NULL DEFAULT NULL COMMENT '按常规修订课程教学大纲、考试大纲',
  `compiling_bilingual_teaching_documents` float(10, 2) NULL DEFAULT NULL COMMENT '采用双语编写教学文件',
  `new_professional_workload1` int(10) NULL DEFAULT NULL COMMENT '新增专业工作量（当年）',
  `new_professional_workload2` int(10) NULL DEFAULT NULL COMMENT '新增专业工作量【第四年（获得学士学位授予资格）】',
  `is_deleted` int(10) UNSIGNED ZEROFILL NOT NULL DEFAULT 0000000000 COMMENT '逻辑删除',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '计算参数表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of parameter
-- ----------------------------
INSERT INTO `parameter` VALUES ('1', 1.00, 1.50, 1.70, 1.90, 0.90, 45, 0.01, 0.90, 1.50, 1.20, 1.10, 0.10, 0.10, 0.90, 0.95, 1.00, 1.05, 1.10, 1.15, 1.20, 1.30, 1.40, 1.50, 1.70, 2.00, 20, 1.00, 0.66, 20, 1.00, 10, 1.00, 0.50, 12, 0.50, 0.50, 0.50, 0.50, 0.70, 0.30, 0.70, 16.00, 6.00, 2.00, 1.50, 0.08, 1.00, 1.50, 2.00, 1.00, 1.50, 12.00, 6.00, 12.00, 6.00, 6.00, 3.00, 1.50, 200, 300, 0000000000, '2020-11-12 18:05:24', '2020-11-29 18:05:28');
INSERT INTO `parameter` VALUES ('1332612130800734209', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0.30, NULL, NULL, NULL, NULL, 0000000001, '2020-11-28 17:07:45', '2020-11-28 17:07:45');

-- ----------------------------
-- Table structure for post_grade
-- ----------------------------
DROP TABLE IF EXISTS `post_grade`;
CREATE TABLE `post_grade`  (
  `id` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '岗位等级编号',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '岗位等级',
  `is_deleted` int(10) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '教师岗位等级表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of post_grade
-- ----------------------------
INSERT INTO `post_grade` VALUES ('1330052459015548930', '一级', 0, '2020-11-21 15:36:32', '2020-11-21 15:36:32');
INSERT INTO `post_grade` VALUES ('1330052547624415234', '二级', 0, '2020-11-21 15:36:53', '2020-11-21 15:36:53');
INSERT INTO `post_grade` VALUES ('1330052590515367938', '三级', 0, '2020-11-21 15:37:03', '2020-11-21 15:37:03');
INSERT INTO `post_grade` VALUES ('1330052626687045634', '四级', 0, '2020-11-21 15:37:12', '2020-11-21 15:37:12');
INSERT INTO `post_grade` VALUES ('1330052661462020098', '五级', 0, '2020-11-21 15:37:20', '2020-11-21 15:37:20');
INSERT INTO `post_grade` VALUES ('1330052718156427265', '六级', 0, '2020-11-21 15:37:34', '2020-11-21 15:37:34');
INSERT INTO `post_grade` VALUES ('1330052755536064514', '七级', 0, '2020-11-21 15:37:43', '2020-11-21 15:37:43');
INSERT INTO `post_grade` VALUES ('1330052786041237506', '八级', 0, '2020-11-21 15:37:50', '2020-11-21 15:37:50');
INSERT INTO `post_grade` VALUES ('1330052813388099586', '九级', 0, '2020-11-21 15:37:57', '2020-11-21 15:37:57');
INSERT INTO `post_grade` VALUES ('1330052854865571841', '十级', 0, '2020-11-21 15:38:06', '2020-11-21 15:38:06');
INSERT INTO `post_grade` VALUES ('1330052901741113345', '十一级', 0, '2020-11-21 15:38:18', '2020-11-21 15:38:18');
INSERT INTO `post_grade` VALUES ('1330052931889770497', '十二级', 0, '2020-11-21 15:38:25', '2020-11-21 15:38:25');
INSERT INTO `post_grade` VALUES ('1330052975950934017', '十三级', 0, '2020-11-21 15:38:35', '2020-11-21 15:38:35');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学生编号',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '学生名称',
  `teacher_id` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '指导教师ID',
  `course_type_id` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '课程类型ID（确认学生名单是属于毕业设计还是capstone）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '学生表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录账号（即教工编号）',
  `password` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录密码',
  `name` varchar(14) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '真实姓名',
  `grade` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '岗位等级',
  `sex` int(10) NULL DEFAULT 0 COMMENT '性别  （默认为男 1  女为 0)',
  `id_card` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号码',
  `telephone` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `university` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '毕业院校',
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系地址',
  `education` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学历',
  `is_deleted` int(10) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '教师信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1330037613620396034', 'string', 'string', 'string', 0, 'string', 'string', 'string', 'string', 'string', 'string', 1, '2020-11-21 14:37:33', '2020-11-21 14:37:33');
INSERT INTO `teacher` VALUES ('1330068033888169985', '54353', '规划计划通过', NULL, 0, '2125232', '17376891574', NULL, NULL, NULL, NULL, 0, '2020-11-21 16:38:25', '2020-11-21 16:38:25');
INSERT INTO `teacher` VALUES ('1330069376384217090', '123456', '啥', NULL, 0, '440921199824345521', NULL, NULL, NULL, NULL, NULL, 0, '2020-11-21 16:43:45', '2020-11-21 16:43:45');
INSERT INTO `teacher` VALUES ('1330070637171027970', '123456', '男', '三级', 1, '4545245225', '17376891574', '广东石油化工学院吧', '1796898704@qq.com', NULL, NULL, 0, '2020-11-21 16:48:46', '2020-11-21 16:48:46');
INSERT INTO `teacher` VALUES ('1332335180555345922', '12345', '额外若翁', '一级', 1, '4523453', '5562323', '是十分安慰', '微软', '让我让', ' 我认为若', 0, '2020-11-27 22:47:15', '2020-11-27 22:47:15');
INSERT INTO `teacher` VALUES ('1334884261362167809', '123456', '白文贤', '11级', 1, '444234554534654', '17376891574', '广东石油化工学院', '179689874@qq.com', '广东省', '本科', 0, '2020-12-04 23:36:24', '2020-12-04 23:36:24');

-- ----------------------------
-- Table structure for teaching_educating_workload
-- ----------------------------
DROP TABLE IF EXISTS `teaching_educating_workload`;
CREATE TABLE `teaching_educating_workload`  (
  `course_type_id` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程类型ID',
  `id` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '编号',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教书育人工作名称',
  `time1` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '监考时间1（正常上班时间）',
  `time2` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '监考/值班时间2（下午4：20~6：20）',
  `time3` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '监考/值班时间3（晚上、双休日、寒暑假）',
  `quantity` int(10) NULL DEFAULT NULL COMMENT '计算数量，次/份/套',
  `is_invigilation` int(10) NULL DEFAULT NULL COMMENT '是否是监考，0为考试值班，1为监考工作',
  `is_deleted` int(10) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '教书育人服务工作量表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for workload_summary
-- ----------------------------
DROP TABLE IF EXISTS `workload_summary`;
CREATE TABLE `workload_summary`  (
  `id` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `term` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学年学期',
  `teacher_id` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教师编号',
  `theory` float(20, 0) NULL DEFAULT NULL COMMENT '理论课工作量',
  `experiment` float(20, 0) NULL DEFAULT NULL COMMENT '实验课工作量',
  `operate` float(20, 0) NULL DEFAULT NULL COMMENT '上机课程工作量',
  `curriculum_design` float(20, 0) NULL DEFAULT NULL COMMENT '课程设计/实训工作量',
  `practice` float(20, 0) NULL DEFAULT NULL COMMENT '实习工作量',
  `graduation_project` float(20, 0) NULL DEFAULT NULL COMMENT '毕业设计工作量',
  `capstone` float(20, 0) NULL DEFAULT NULL COMMENT 'Capstone课程工作量',
  `total1` float(20, 0) NULL DEFAULT NULL COMMENT '合计工作量1（除教书育人工作量之外）',
  `teaching_educating_service` float(20, 0) NULL DEFAULT NULL COMMENT '教书育人服务工作量',
  `total2` float(20, 0) NULL DEFAULT NULL COMMENT '合计工作量2（包含教书育人工作量在内）',
  `is_deleted` int(10) UNSIGNED ZEROFILL NOT NULL DEFAULT 0000000000 COMMENT '逻辑删除',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '工作量汇总表' ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
