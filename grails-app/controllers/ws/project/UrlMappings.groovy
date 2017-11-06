package ws.project

class UrlMappings {

    static mappings = {
        "/" (controller: 'Api', action: 'index')
        "500"(view:'/error')

        "/api/books" (controller: 'Api', action: 'book')
        "/api/books/$id" (controller: 'Api', action: 'book')
        "/api/libraries" (controller: 'Api', action: 'library')
        "/api/libraries/$id" (controller: 'Api', action: 'library')
        "/api/libraries/$id/books" (controller: "Api", action: "libraryBook")
        "/api/libraries/$id/books/$bookId" (controller: "Api", action: "libraryBook")

    }
}
