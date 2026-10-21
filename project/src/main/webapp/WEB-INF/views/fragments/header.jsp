<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<header class="topbar"><a class="brand" href="${pageContext.request.contextPath}/">Shop<span>Sphere</span></a>
<form class="search" action="${pageContext.request.contextPath}/products"><input name="q" placeholder="Search products..." value="${param.q}"><button>Search</button></form>
<nav><a href="${pageContext.request.contextPath}/products">Shop</a><a href="${pageContext.request.contextPath}/cart">Cart</a><a href="${pageContext.request.contextPath}/orders">Orders</a>
<c:choose><c:when test="${not empty sessionScope.user}"><span class="welcome">Hi, ${sessionScope.user.name}</span><form class="inline" action="${pageContext.request.contextPath}/logout" method="post"><button class="linkbtn">Logout</button></form></c:when><c:otherwise><a href="${pageContext.request.contextPath}/login">Login</a></c:otherwise></c:choose></nav></header>
