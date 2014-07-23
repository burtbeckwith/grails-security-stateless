class GrailsSpringSecurityStatelessGrailsPlugin {
    def version = "0.1"
    def grailsVersion = "2.2 > *"
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
        "grails-app/views/error.gsp"
    ]

    // TODO Fill in these fields
    def title = "Grails Spring Security Stateless Plugin"
    def author = "Pablo Alba"
    def authorEmail = "pablo.alba@kaleidos.net"
    def description = '''\
 Grails plugin to implement stateless authentication using Spring Security.
'''

    // URL to the plugin's documentation
    def documentation = "http://grails.org/plugin/grails-spring-security-stateless"

    def license = "APACHE"

    def organization = [ name: "Kaleidos Open Source SL", url: "http://kaleidos.net/" ]

//    def developers = [ [ name: "Joe Bloggs", email: "joe@bloggs.net" ]]

    // Online location of the plugin's browseable source code.
    def scm = [ url: "https://github.com/pabloalba/grails-spring-security-stateless" ]


}
