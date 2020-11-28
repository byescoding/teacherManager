import Vue from 'vue'
import Router from 'vue-router'

// in development-env not use lazy-loading, because lazy-loading too many pages will cause webpack hot update too slow. so only in production use lazy-loading;
// detail: https://panjiachen.github.io/vue-element-admin-site/#/lazy-loading

Vue.use(Router)

/* Layout */
import Layout from '../views/layout/Layout'

/**
* hidden: true                   if `hidden:true` will not show in the sidebar(default is false)
* alwaysShow: true               if set true, will always show the root menu, whatever its child routes length
*                                if not set alwaysShow, only more than one route under the children
*                                it will becomes nested mode, otherwise not show the root menu
* redirect: noredirect           if `redirect:noredirect` will no redirect in the breadcrumb
* name:'router-name'             the name is used by <keep-alive> (must set!!!)
* meta : {
    title: 'title'               the name show in submenu and breadcrumb (recommend set)
    icon: 'svg-name'             the icon show in the sidebar,
  }
**/
export const constantRouterMap = [
  { path: '/login', component: () => import('@/views/login/index'), hidden: true },
  { path: '/404', component: () => import('@/views/404'), hidden: true },

  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    name: 'Dashboard',
    hidden: true,
    children: [{
      path: 'dashboard',
      component: () => import('@/views/dashboard/index')
    }]
  },

  // 讲师管理
  {
    path: '/teacher',
    component: Layout,
    redirect: '/teacher/list',
    name: 'Teacher',
    meta: {
      title: '教师管理',
      icon: 'teacherAdmin'
    },
    children: [
      {
        path: 'list',
        name: 'TeacherList',
        component: () => import('@/views/teacher/list'),
        meta: {
          title: '教师列表',
          icon: 'teacher'
        }
      },
      {
        path: 'create',
        name: 'TeacherCreate',
        component: () => import('@/views/teacher/form'),
        meta: {
          title: '添加教师',
          icon: 'teacherAdd'
        }
      },
      {
        path: 'edit/:id',
        name: 'TeacherEdit',
        component: () => import('@/views/teacher/form'),
        meta: { title: '编辑教师' },
        hidden: true
      }
    ]
  },

  // 课程管理

  // 课程管理
  {
    path: '/course',
    component: Layout,
    redirect: '/course/list',
    name: 'Course',
    meta: {
      title: '课程管理',
      icon: 'course'
    },
    children: [
      {
        path: 'list',
        name: 'CourseList',
        component: () => import('@/views/course/list'),
        meta: {
          title: '课程列表',
          icon: 'courseAdmin'
        }
      },
      {
        path: 'info',
        name: 'CourseInfo',
        component: () => import('@/views/course/form'),
        meta: {
          title: '添加课程',
          icon: 'addCourse'
        }
      },
      {
        path: 'edit/:id',
        name: 'CourseInfoEdit',
        component: () => import('@/views/course/form'),
        meta: { title: '添加课程' },
        hidden: true
      }

    ]
  },

  // 班级管理
  {
    path: '/class',
    component: Layout,
    redirect: '/class/list',
    name: 'Class',
    meta: {
      title: '班级管理',
      icon: 'class'
    },
    children: [
      {
        path: 'list',
        name: 'ClassList',
        component: () => import('@/views/class/list'),
        meta: {
          title: '班级列表',
          icon: 'classAdmin'
        }
      },
      {
        path: 'info',
        name: 'ClassInfo',
        component: () => import('@/views/class/form'),
        meta: {
          title: '添加班级',
          icon: 'addCourse'
        }
      },
      {
        path: 'edit/:id',
        name: 'ClassInfoEdit',
        component: () => import('@/views/class/form'),
        meta: { title: '添加班级' },
        hidden: true
      }

    ]
  },

  // 参数管理
  {
    path: '/param',
    component: Layout,
    redirect: '/param/list',
    name: 'Parameter',
    meta: {
      title: '参数管理',
      icon: 'param'
    },
    children: [
      {
        path: 'list',
        name: 'ParameterList',
        component: () => import('@/views/param/list'),
        meta: {
          title: '参数列表',
          icon: 'parameterAdmin'
        }
      },
      {
        path: 'info',
        name: 'ParameterInfo',
        component: () => import('@/views/param/form'),
        meta: {
          title: '添加参数',
          icon: 'addParam'
        }
      },
      {
        path: 'edit/:id',
        name: 'ParameterInfoEdit',
        component: () => import('@/views/param/form'),
        meta: { title: '添加参数' },
        hidden: true
      }

    ]
  },

  // 数据导入
  {
    path: '/import',
    component: Layout,
    redirect: '/import/importData',
    name: 'Parameter',
    meta: {
      title: '数据导入',
      icon: 'import'
    },
    children: [
      {
        path: 'list',
        name: 'ParameterList',
        component: () => import('@/views/import/form'),
        meta: {
          title: '导入数据',
          icon: 'importData'
        }
      }

    ]
  },

  { path: '*', redirect: '/404', hidden: true }
]

export default new Router({
  // mode: 'history', //后端支持可开
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRouterMap
})
