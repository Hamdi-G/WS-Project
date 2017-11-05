package ws.project

import grails.converters.JSON

class ApiController {

    def index(){
        render text: "welcome in Libraries & Books web service!"
    }

    def book() {

        switch (request.getMethod()) {
            case "GET":
                if (params.id != null) {
                    def bookInstance = Book.get(params.id)
                    if (bookInstance) {
                        render bookInstance as JSON
                    } else
                        render status: 404
                } else {
                    def booksInstance = Book.getAll()
                    if (booksInstance) {
                        render booksInstance as JSON
                    } else
                        render status: 404
                }
                break

            case "POST":
                if (params.library != null) {
                    if (!Library.get(params.library.id)) {
                        render status: 404
                        return
                    }
                }
                def bookInstance = new Book(params)
                if (bookInstance.save(flush: true)) {
                    render bookInstance as JSON
                    render status: 201
                } else {
                    render status: 400
                }
                break

            case "PUT":
                if (params.id) {
                    if (params.library != null) {
                        if (!Library.get(params.library.id)) {
                            render status: 404
                            return
                        }
                    }
                    def bookInstance = Book.findById(params.id)
                    if (!bookInstance){
                        render status: 404
                        return
                    }
                    bookInstance.properties = params
                    if (bookInstance.save(flush: true)) {
                        render bookInstance as JSON
                    } else {
                        render status: 400
                    }
                } else {
                    render status: 400
                }
                break

            case "DELETE":
                if (params.id) {
                    def bookInstance = Book.findById(params.id)
                    if (bookInstance) {
                        bookInstance.delete(flush: true)
                        render status: 204
                    } else {
                        render status: 404
                    }
                } else
                    render status: 400
                break

            default:
                render status: 405
                break;
        }
    }

    def library() {

        switch (request.getMethod()) {
            case "GET":
                if (params.id != null) {
                    def libraryInstance = Library.get(params.id)
                    if (libraryInstance) {
                        render libraryInstance as JSON
                    } else
                        render status: 404
                } else {
                    def librariesInstance = Library.getAll()
                    if (librariesInstance) {
                        render librariesInstance as JSON
                    } else
                        render status: 404
                }
                break

            case "POST":
                def libraryInstance = new Library(params)
                if (libraryInstance.save(flush: true)) {
                    render libraryInstance as JSON
                    render status: 201
                } else {
                    render status: 400
                }
                break

            case "PUT":
                if (params.id) {
                    def libraryInstance = Library.findById(params.id)
                    if (!libraryInstance){
                        render status: 404
                        return
                    }
                    libraryInstance.properties = params
                    if (libraryInstance.save(flush: true)) {
                        render libraryInstance as JSON
                    } else {
                        render status: 400
                    }
                } else {
                    render status: 400
                }
                break

            case "DELETE":
                if (params.id) {
                    def libraryInstance = Library.findById(params.id)
                    if (libraryInstance) {
                        libraryInstance.delete(flush: true)
                        render status: 204
                    } else {
                        render status: 404
                    }
                } else
                    render status: 400
                break

            default:
                render status: 405
                break;
        }
    }

    def libraryBook() {

        switch (request.getMethod()) {
            case "GET":
                if (Library.findById(params.id)) {
                    if (params.bookId != null) {
                        if (Library.findById(params.id).books.find({ it.id == params.bookId.toInteger() })) {
                            def bookInstance = Book.get(params.bookId)
                            if (bookInstance) {
                                render bookInstance as JSON
                            } else
                                render status: 404
                        } else
                            render status: 404
                    } else {
                        def booksInstance = Book.findAllByLibrary(Library.findById(params.id))
                        if (booksInstance) {
                            render booksInstance as JSON
                        } else
                            render status: 404
                    }
                } else
                    render status: 404
                break

            case "POST":
                if (Library.findById(params.id)) {
                    if (params.library != null) {
                        if (!Library.get(params.library.id)) {
                            render status: 404
                            return
                        }
                    }
                    def bookInstance = new Book(params)
                    if (bookInstance.save(flush: true)) {
                        render bookInstance as JSON
                        render status: 201
                    } else {
                        render status: 400
                    }
                } else
                    render status: 404
                break


            case "PUT":
                if (Library.findById(params.id)) {
                    if (params.id) {
                        if (params.library != null) {
                            if (!Library.get(params.library.id)) {
                                render status: 404
                                return
                            }
                        }
                        if (Library.findById(params.id).books.find({ it.id == params.bookId.toInteger() })) {
                            def bookInstance = Book.findById(params.bookId)
                            bookInstance.properties = params
                            if (bookInstance.save(flush: true)) {
                                render bookInstance as JSON
                            } else {
                                render status: 400
                            }
                        } else
                            render status: 404

                    } else {
                        render status: 400
                    }
                } else
                    render status: 404
                break

            case "DELETE":
                if (Library.findById(params.id)) {

                    if (params.id) {
                        if (Library.findById(params.id).books.find({ it.id == params.bookId.toInteger() })) {
                            def bookInstance = Book.findById(params.bookId)
                            if (bookInstance) {
                                Library.findById(params.id).books.remove(bookInstance)
                                bookInstance.delete(flush: true)
                                render status: 204
                            } else {
                                render status: 404
                            }
                        } else
                            render status: 404
                    } else
                        render status: 400
                } else
                    render status: 404
                break

            default:
                render status: 405
                break;
        }
    }
}
