<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="fragments/header.jsp" %>

<!DOCTYPE html><html><head><title>ShopSphere | Discover your next favorite</title><link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"></head><body>
    
</body>
<main class="container"><section class="hero"><div><p class="eyebrow">THE EVERYDAY EDIT</p><h1>Good finds.<br><em>Better living.</em></h1><p class="lead">Discover thoughtful picks for your style, space, and everyday routine.</p><a class="button" href="${pageContext.request.contextPath}/products">Explore the collection</a></div><img src="https://images.unsplash.com/photo-1441986300917-64674bd600d8?auto=format&fit=crop&w=1000&q=85" alt="Modern retail store"></section>
<section class="trust"><div><strong>Curated picks</strong><span>Useful finds for daily life</span></div><div><strong>Easy checkout</strong><span>A simple shopping journey</span></div><div><strong>Order tracking</strong><span>See your order history</span></div></section>
<section class="section-head"><div><p class="eyebrow">START EXPLORING</p><h2>Shop by mood</h2></div><a href="${pageContext.request.contextPath}/products">View all products â†—</a></section><div class="category-grid"><a href="${pageContext.request.contextPath}/products?q=Fashion" class="category fashion"><span>01 / STYLE</span><h3>Fashion finds</h3></a><a href="${pageContext.request.contextPath}/products?q=Electronics" class="category tech"><span>02 / TECH</span><h3>Everyday tech</h3></a><a href="${pageContext.request.contextPath}/products?q=Home" class="category home"><span>03 / HOME</span><h3>Make room for good</h3></a></div></main>
<%@ include file="fragments/footer.jsp" %></body></html>

