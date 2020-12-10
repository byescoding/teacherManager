/*
 Navicat Premium Data Transfer

 Source Server         : MySQL8.0.12
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : new_teachermanager

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 10/12/2020 22:37:49
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
INSERT INTO `admin` VALUES ('123456', '123456', 'admin', 0, '教务处秘书', '13609876542', 0, '2020-12-10 21:53:18', '2020-12-10 21:53:21');
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
  `is_new_major` int(10) NULL DEFAULT 0 COMMENT '是否为新增专业班级，0为false，1为true',
  `is_deleted` int(10) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '班级表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of classes
-- ----------------------------
INSERT INTO `classes` VALUES ('17000001', '计算机17-1', 48, '张合', 0, 0, '2020-12-10 14:08:17', '2020-12-10 14:08:17');
INSERT INTO `classes` VALUES ('17000002', '计算机17-2', 49, '陈福', 0, 0, '2020-12-10 14:22:26', '2020-12-10 14:22:26');
INSERT INTO `classes` VALUES ('17000003', '互联网17-1', 45, '张覅', 0, 0, '2020-12-10 15:06:30', '2020-12-10 15:06:30');
INSERT INTO `classes` VALUES ('17000004', '互联网17-2', 45, '张季', 0, 0, '2020-12-10 22:03:02', '2020-12-10 22:03:05');
INSERT INTO `classes` VALUES ('17000005', '物联网17-1', 46, '姚琛', 0, 0, '2020-12-10 22:04:27', '2020-12-10 22:04:30');
INSERT INTO `classes` VALUES ('17000006', '物联网17-2', 48, '肖剑', 0, 0, '2020-12-10 22:05:02', '2020-12-10 22:05:06');
INSERT INTO `classes` VALUES ('17000007', '物理17-1', 45, '曾诚', 0, 0, '2020-12-10 22:06:12', '2020-12-10 22:06:15');
INSERT INTO `classes` VALUES ('17000008', '物理17-2', 44, '陈龙', 0, 0, '2020-12-10 22:08:12', '2020-12-10 22:08:16');
INSERT INTO `classes` VALUES ('18000001', '计算机18-1', 46, '金晨', 0, 0, '2020-12-10 22:08:50', '2020-12-10 22:08:53');
INSERT INTO `classes` VALUES ('18000002', '计算机18-2', 48, '王诗意', 0, 0, '2020-12-10 22:09:29', '2020-12-10 22:09:32');
INSERT INTO `classes` VALUES ('18000003', '互联网18-1', 45, '刘狄', 0, 0, '2020-12-10 22:10:01', '2020-12-10 22:10:04');
INSERT INTO `classes` VALUES ('18000004', '互联网18-2', 47, '赖源', 0, 0, '2020-12-10 22:11:01', '2020-12-10 22:11:04');
INSERT INTO `classes` VALUES ('18000005', '互联网18-3', 45, '唐莹', 0, 0, '2020-12-10 22:11:31', '2020-12-10 22:11:34');
INSERT INTO `classes` VALUES ('18000006', '物联网18-1', 45, '张波顿', 0, 0, '2020-12-10 22:12:45', '2020-12-10 22:12:48');
INSERT INTO `classes` VALUES ('18000007', '物联网18-2', 45, '陈恒', 0, 0, '2020-12-10 22:13:17', '2020-12-10 22:13:19');
INSERT INTO `classes` VALUES ('18000008', '物理18-1', 45, '陈云贵', 0, 0, '2020-12-10 22:13:51', '2020-12-10 22:13:54');
INSERT INTO `classes` VALUES ('18000009', '物理18-2', 45, '陈安顺', 0, 0, '2020-12-10 22:14:31', '2020-12-10 22:14:33');
INSERT INTO `classes` VALUES ('19000001', '计算机19-1', 48, '梁高', 0, 0, '2020-12-10 22:15:24', '2020-12-10 22:15:28');
INSERT INTO `classes` VALUES ('19000002', '计算机19-2', 49, '王丽莎', 0, 0, '2020-12-10 22:16:03', '2020-12-10 22:16:05');
INSERT INTO `classes` VALUES ('19000003', '互联网19-1', 45, '马洪', 0, 0, '2020-12-10 22:16:30', '2020-12-10 22:16:32');
INSERT INTO `classes` VALUES ('19000004', '互联网19-2', 45, '欧阳锋', 0, 0, '2020-12-10 22:16:56', '2020-12-10 22:16:58');
INSERT INTO `classes` VALUES ('19000005', '物联网19-1', 46, '梁默克', 0, 0, '2020-12-10 22:17:24', '2020-12-10 22:17:26');
INSERT INTO `classes` VALUES ('19000006', '物联网19-2', 48, '陈发财', 0, 0, '2020-12-10 22:17:58', '2020-12-10 22:18:00');
INSERT INTO `classes` VALUES ('19000007', '物理19-1', 45, '陈朵', 0, 0, '2020-12-10 22:18:55', '2020-12-10 22:19:00');
INSERT INTO `classes` VALUES ('19000008', '物理19-2', 45, '张程', 0, 0, '2020-12-10 22:19:31', '2020-12-10 22:19:33');
INSERT INTO `classes` VALUES ('20000001', '计算机20-1', 45, '张格', 0, 0, '2020-12-10 22:21:41', '2020-12-10 22:21:44');
INSERT INTO `classes` VALUES ('20000002', '计算机20-2', 45, '陈正', 0, 0, '2020-12-10 22:22:22', '2020-12-10 22:22:25');
INSERT INTO `classes` VALUES ('20000003', '计算机20-3', 45, '陈宏发', 0, 0, '2020-12-10 22:22:56', '2020-12-10 22:22:58');
INSERT INTO `classes` VALUES ('20000004', '计算机20-4', 45, '梁耕', 0, 0, '2020-12-10 22:23:22', '2020-12-10 22:23:24');
INSERT INTO `classes` VALUES ('20000005', '互联网20-1', 45, '梁定', 0, 0, '2020-12-10 22:24:00', '2020-12-10 22:24:02');
INSERT INTO `classes` VALUES ('20000006', '互联网20-2', 45, '梁度使', 0, 0, '2020-12-10 22:24:28', '2020-12-10 22:24:30');
INSERT INTO `classes` VALUES ('20000007', '物联网20-1', 45, '杨莹莹', 0, 0, '2020-12-10 22:25:03', '2020-12-10 22:25:05');
INSERT INTO `classes` VALUES ('20000008', '物联网20-2', 45, '梁妮妮', 0, 0, '2020-12-10 22:25:30', '2020-12-10 22:25:32');
INSERT INTO `classes` VALUES ('20000009', '物理20-1', 45, '梁达', 0, 0, '2020-12-10 22:25:55', '2020-12-10 22:25:58');
INSERT INTO `classes` VALUES ('20000010', '物理20-2', 45, '杨洋', 0, 0, '2020-12-10 22:26:31', '2020-12-10 22:26:34');
INSERT INTO `classes` VALUES ('20000011', '大数据20-1', 45, '颜莉娜', 1, 0, '2020-12-10 22:27:16', '2020-12-10 22:27:19');
INSERT INTO `classes` VALUES ('20000012', '大数据20-2', 45, '亚历山大', 1, 0, '2020-12-10 22:27:58', '2020-12-10 22:28:00');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '编号',
  `term` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学年学期',
  `course_type_id` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '具体课程/教书育人工作编号',
  `class_time` int(10) NULL DEFAULT NULL COMMENT '计划学时',
  `weeks` int(10) NULL DEFAULT NULL COMMENT '计划周数',
  `class_number` int(10) NULL DEFAULT NULL COMMENT '教班数量',
  `class_id` char(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教班编号',
  `student_number` int(10) NULL DEFAULT NULL COMMENT '排课人数',
  `guide_inspect_frequency` int(10) NULL DEFAULT NULL COMMENT '指导/考察次数（用于确认课程设计、实训、实习的课程系数）',
  `teacher_id` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '授课教师编号（用于获取teacher表的教师名）',
  `is_new` int(10) NULL DEFAULT 1 COMMENT '是否为“开新课/新开课”',
  `is_xicheng` int(10) NULL DEFAULT 1 COMMENT '是否在西城校区教学',
  `is_deleted` int(10) NOT NULL DEFAULT 0 COMMENT '逻辑删除，1（true）已删除，0（false）未删除',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '老师授课表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for course_type
-- ----------------------------
DROP TABLE IF EXISTS `course_type`;
CREATE TABLE `course_type`  (
  `id` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '具体课程/教书育人工作编号',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '具体课程/教书育人工作名称',
  `parent_id` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '课程类型编号',
  `parent_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程类型名称',
  `is_deleted` int(10) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  `gmt_createc` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '课程信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of course_type
-- ----------------------------
INSERT INTO `course_type` VALUES ('000001', '面向对象与Java实现', '0', '理论课', 0, '2020-12-09 23:00:10', '2020-12-09 23:00:12');
INSERT INTO `course_type` VALUES ('000002', '面向对象与Java实现', '0', '实验课', 0, '2020-12-09 23:00:48', '2020-12-09 23:00:51');
INSERT INTO `course_type` VALUES ('000003', 'Python', '0', '理论课', 0, '2020-12-09 23:02:23', '2020-12-09 23:02:26');
INSERT INTO `course_type` VALUES ('000004', 'Python', '0', '实验课', 0, '2020-12-10 22:32:36', '2020-12-10 22:32:39');
INSERT INTO `course_type` VALUES ('000005', 'JavaWeb技术', '0', '理论课', 0, '2020-12-10 22:33:06', '2020-12-10 22:33:10');
INSERT INTO `course_type` VALUES ('000006', 'JavaWeb技术', '0', '实验课', 0, '2020-12-10 22:33:35', '2020-12-10 22:33:37');
INSERT INTO `course_type` VALUES ('000007', '计算机网络', '0', '理论课', 0, '2020-12-10 22:34:02', '2020-12-10 22:34:05');
INSERT INTO `course_type` VALUES ('000008', '计算机网络', '0', '实验课', 0, '2020-12-10 22:34:31', '2020-12-10 22:34:35');
INSERT INTO `course_type` VALUES ('000009', '数据结构', '0', '理论课', 0, '2020-12-10 22:35:00', '2020-12-10 22:35:03');
INSERT INTO `course_type` VALUES ('000010', '数据结构', '0', '实验课', 0, '2020-12-10 22:37:29', '2020-12-10 22:37:32');

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
  `repeat_course` float(10, 2) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '重复班课合班系数（用于第二个教学大班的计算）',
  `theory_standard_number` int(10) NULL DEFAULT NULL COMMENT '理论课单班标准人数',
  `theory_excess_student` float(10, 2) NULL DEFAULT NULL COMMENT '理论课超额学生合班累加系数',
  `experiment_repeat_course` float(10, 2) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '实验课重复班课合班系数',
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
INSERT INTO `parameter` VALUES ('1', 1.00, 1.50, 1.70, 1.90, 0000000.90, 45, 0.01, 0000000.90, 1.50, 1.20, 1.10, 0.10, 0.10, 0.90, 0.95, 1.00, 1.05, 1.10, 1.15, 1.20, 1.30, 1.40, 1.50, 1.70, 2.00, 20, 1.00, 0.66, 20, 1.00, 10, 1.00, 0.50, 12, 0.50, 0.50, 0.50, 0.50, 0.70, 0.30, 0.70, 16.00, 6.00, 2.00, 1.50, 0.08, 1.00, 1.50, 2.00, 1.00, 1.50, 12.00, 6.00, 12.00, 6.00, 6.00, 3.00, 1.50, 200, 300, 0000000000, '2020-11-12 18:05:24', '2020-11-29 18:05:28');
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
  `course_type_id` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '具体课程/教书育人工作编号',
  `class_id` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '班级编号',
  `is_deleted` int(10) NULL DEFAULT NULL COMMENT '逻辑删除',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
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
INSERT INTO `teacher` VALUES ('1330068033888169985', '54353', '规划计划通过', NULL, 0, '2125232', NULL, NULL, NULL, NULL, NULL, 1, '2020-11-21 16:38:25', '2020-11-21 16:38:25');
INSERT INTO `teacher` VALUES ('1330069376384217090', '123456', '啥', NULL, 0, '440921199824345521', NULL, NULL, NULL, NULL, NULL, 0, '2020-11-21 16:43:45', '2020-11-21 16:43:45');
INSERT INTO `teacher` VALUES ('1330070637171027970', '123456', '男', '三级', 1, '4545245225', '17376891574', '广东石油化工学院吧', '1796898704@qq.com', NULL, NULL, 0, '2020-11-21 16:48:46', '2020-11-21 16:48:46');
INSERT INTO `teacher` VALUES ('1332335180555345922', '12345', '额外若翁', '一级', 1, '4523453', '5562323', '是十分安慰', '微软', '让我让', ' 我认为若', 0, '2020-11-27 22:47:15', '2020-11-27 22:47:15');
INSERT INTO `teacher` VALUES ('1334884261362167809', '123456', '白文贤', '11级', 1, '444234554534654', '17376891574', '广东石油化工学院', '179689874@qq.com', '广东省', '本科', 0, '2020-12-04 23:36:24', '2020-12-04 23:36:24');

-- ----------------------------
-- Table structure for teaching_educating_workload
-- ----------------------------
DROP TABLE IF EXISTS `teaching_educating_workload`;
CREATE TABLE `teaching_educating_workload`  (
  `id` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '编号',
  `course_type_id` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '具体课程/教书育人工作编号',
  `teacher_id` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教师编号',
  `quantity` int(10) NULL DEFAULT NULL COMMENT '计算数量，次/份/套',
  `is_bilingual` int(10) NULL DEFAULT NULL COMMENT '是否采用双语编写教学文件',
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
