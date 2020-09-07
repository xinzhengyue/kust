<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="${pageContext.request.contextPath}/img/user2-160x160.jpg"
                     class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p></p>
                <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
            </div>
        </div>

        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
            <li class="header">菜单</li>
            <li id="admin-index"><a
                    href="${pageContext.request.contextPath}/pages/mainte.jsp"><i
                    class="fa fa-dashboard"></i> <span>首页</span></a></li>


            <li class="treeview"><a href="#"> <i class="fa fa-cube"></i>
                <span>功能</span> <span class="pull-right-container"> <i
                        class="fa fa-angle-left pull-right"></i>
				</span>
            </a>
                <ul class="treeview-menu">

                    <li id="system-setting"><a
                            href="${pageContext.request.contextPath}/wwx/selectone">
                        <i class="fa fa-circle-o"></i> 个人信息
                    </a></li>
                    <li id="system-setting"><a
                            href="${pageContext.request.contextPath}/course/findAlls"> <i
                            class="fa fa-circle-o"></i> 课程管理
                    </a></li>

                </ul></li>

        </ul>
    </section>
    <!-- /.sidebar -->
</aside>
