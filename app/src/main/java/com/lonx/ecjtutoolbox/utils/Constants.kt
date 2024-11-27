package com.lonx.ecjtutoolbox.utils

object Constants {
    const val USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 Chrome/58.0.3029.110 Safari/537.3"
    const val ECJTU_DOMAIN = "ecjtu.edu.cn"
    const val PORTAL_ECJTU_DOMAIN = "http://portal.$ECJTU_DOMAIN/dcp/index.jsp"
    const val CAS_ECJTU_DOMAIN = "cas.$ECJTU_DOMAIN"
    const val JWXT_ECJTU_DOMAIN = "jwxt.$ECJTU_DOMAIN"
    const val PWD_ENC_URL = "http://$CAS_ECJTU_DOMAIN/cas/loginPasswdEnc"
    const val ECJTU_LOGIN_URL = "http://$CAS_ECJTU_DOMAIN/cas/login"  // 智慧交大登录页
    const val JWXT_LOGIN_URL = "https://$JWXT_ECJTU_DOMAIN/stuMag/Login_dcpLogin.action"  // 教务系统登录页
    const val ECJTU2JWXT_URL = "http://$CAS_ECJTU_DOMAIN/cas/login?service=https%3A%2F%2Fjwxt.ecjtu.edu.cn%2FstuMag%2FLogin_dcpLogin.action"  // 智慧交大登录教务系统
    const val GET_CLASSES_URL = "https://$JWXT_ECJTU_DOMAIN/Schedule/Weekcalendar_getTodayWeekcalendar.action"  // 获取课程信息(post)
    const val GET_GPA_URL = "https://$JWXT_ECJTU_DOMAIN/scoreQuery/stuScoreQue_getStuScore.action?item=0401"  // 获取成绩信息(get)
    const val WEIXIN_JWXT_URL = "https://$JWXT_ECJTU_DOMAIN/weixin/CalendarServlet"
    const val GET_ELERTIVE_COURSE_URL_TEMPLATE = "https://$JWXT_ECJTU_DOMAIN/infoQuery/XKStu_findTerm.action"  // 获取选修课程信息(get)
    const val GET_STU_PROFILE_URL = "http://portal.$ECJTU_DOMAIN/dcp/profile/profile.action" // 获取个人信息
    const val GET_STU_INFO_URL= "http://portal.$ECJTU_DOMAIN/dcp/forward.action?path=/portal/portal&p=info" // 个人信息主页
    const val STU_AVATAR_L_URL= "http://portal.$ECJTU_DOMAIN/dcp/uploadfiles/avatar/large/"
}