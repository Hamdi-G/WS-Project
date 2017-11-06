package ws.project

import com.mysecurerest.*

class BootStrap {

    def init = { servletContext ->

        def library_1 = new Library(name: "lib1", address: "nice", yearCreated: 1994)
                .addToBooks(new Book(name: "book1",releaseDate: 2000, isbn: "1242H14", author: "Hamdi" ))
                .save(flush:true)

        def library_2 = new Library(name: "lib2", address: "sophia", yearCreated: 2017)
                .addToBooks(new Book(name: "book2",releaseDate: 2004, isbn: "124234G", author: "Gazzah" ))
                .save(flush:true)

        def role1 = new Authority(authority:"ROLE_ADMIN").save flush:true
        def user1 = new User(username:"admin",password:"password").save flush:true
        UserAuthority.create(user1,role1)
    }
    def destroy = {
    }
}
