function loadList() {
    $.ajax({
        type: "GET",
        url: "${pageContext.request.contextPath}/reqLoadListClient",
    });
}
