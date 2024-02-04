#Робин Мартин - Хороший код не требует коментариев.
#Коментарий = Признать поражение

class Check:


    def __init__(self, name, otvet="", x = 1):
        self.resalt = 0
        self.x = x
        self.name = name
        self.otvet = otvet
        
        self.right_answer = {

            'question1': "is",
            'question2': "am",
            'question3': "in",

        }
        

    def question(self):
        return "Привет, ", self.name, ", начинаем тренировку!"
    

    def question1(self):
        
        print(": ", self.otvet)
        if self.otvet == self.right_answer["question" + str(self.x)]:

            print("Вы получаете 10 баллов!")
            return 1
            
        else:
            print("Неправильно.")
            print("Правильный ответ: ", self.right_answer["question" + str(self.x)])
            return 0
    

    def End(self, con):
        print("Вот и все ", self.name, " !")
        print("Вы ответили на ", str(int(con / 10)), "вопроса из 3 верно.")
        print("Вы ответили на ", con, "баллов")
        print("Это", (100 * 3) / con, "процентов")


def main():
    name = input("Раскажи, как тебя зовут!")
    if (len(name) > 1):
        task = Check(name)
        print(task.question())
        base(name, x = 1, con = 0)

    else:
        print("Имя Слишком короткое")
        main()


def base(name, x, con):
    
    list_question = ["My name --- Vova", "I --- a coder", "I live --- Moscow"]
    if (x - 1 < len(list_question)):
        print(list_question[x - 1])
        otvet = input()
        task = Check(name, otvet, x)
        s = task.question1()
        if s == 1:
            con += 10
            print(con)
        x += 1
        base(name, x, con)

    else:
        task = Check(name)
        task.End(con)
        


if __name__ == "__main__":
    print("Привет! Предлагаю проверить свои знания английского!")
    main()