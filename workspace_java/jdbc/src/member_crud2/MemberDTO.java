<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
<!-- 
<bean id="service" class="memberservice.MemberBasicService">
	<property name="memberdao" ref="dao"/>
	<property name="pointdao" ref="dao2"/>
</bean> 
-->
<bean id="service" class="memberservice.MemberBasicService">
<!-- membersevice -> memberservice -->
	<property name="dao" ref="dao"/>
</bean>

<bean id="dao2" class="memberservice.PointDAO">
<!-- pointdao -> PointDAO -->
	<property name="point" value="10000"/>
</bean>

<bean id= "dao" class="memberservice.MemberDAO" >
	<property name = "dto" ref="dto3"></property>
</bean>

<bean id= "dto1" class="memberservice.MemberDTO" >
	<property name="id" value="spring" />
	<property name="pw" value="1111" />
	<property name="name" value="김봄" />
	<property name="email" value="spring@1.net" />
	<property name="phone" value="01011111111" />
	<property name="address" value="서울" />
	<property name="indate" value="2023-01-11" />
</bean>

<bean id= "dto2" class="memberservice.MemberDTO" >
	<property name="id" value="framework" />
	<property name="pw" value="2222" />
	<property name="name" value="프레임박" />
	<property name="email" value="framework@1.net" />
	<property name="phone" value="01022222222" />
	<property name="address" value="파주" />
	<property name="indate" value="2023-01-11" />
</bean>

<bean id= "dto3" class="memberservice.MemberDTO" >
	<constructor-arg name = "id" value = "java"/>
	<constructor-arg name = "pw" value = "3333"/>
	<!-- 나머지는 null인 상태로 둠 -->
</bean>
</beans>
