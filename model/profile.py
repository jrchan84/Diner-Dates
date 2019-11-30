
class Person:
    def __init__(self, password, name, email, preferences):
        self.password = password
        self.name = name
        self.email = email
        self.preferences = preferences

    def getname(self):
        return self.name

    def getemail(self):
        return self.email

    def getpreferences(self):
        return self.preferences

    def setname(self, name):
        self.name = name

    def setemail(self, email):
        self.email = email

    def addpreference(self, category):
        self.preferences.append(category)
