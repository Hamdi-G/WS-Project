package ws.project

class UrlMappings {

    static mappings = {
        "/" (controller: 'Api', action: 'index')
        "500"(view:'/error')

        "/books" (controller: 'Api', action: 'book')
        "/books/$id" (controller: 'Api', action: 'book')
        "/libraries" (controller: 'Api', action: 'library')
        "/libraries/$id" (controller: 'Api', action: 'library')
        "/libraries/$id/books" (controller: "Api", action: "libraryBook")
        "/libraries/$id/books/$bookId" (controller: "Api", action: "libraryBook")

    }
}
