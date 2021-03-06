package Swing;

public class ExampleSwing {
    public static void main(String[] args) {

    }
}

/*
----------------------------------------------------------------------------------------------------------------------
НА ЗАМЕТКУ! Библиотека Swing не является полной заменой библиотеки AWT. Она построена на основе архитектуры AWT. Библиотека
Swing просто дает больше возможностей для создания пользовательского интерфейса. При написании программы средствами Swing,
по существу, используются основные ресурсы AWT. Здесь и далее под Swing подразумеваются платформенно-независимые классы
для создания “рисованного” пользовательского интерфейса, а под AWT — базовые средства конкретной платформы для работы с
окнами, включая обработку событий.
----------------------------------------------------------------------------------------------------------------------
Разумеется, элементы пользовательского интерфейса из библиотеки Swing появляются на экране немного медленнее, чем аналогичные
компоненты из библиотеки AWT. Но, как показывает опыт, на современных компьютерах этого практически незаметно. С другой
стороны, у библиотеки Swing имеется ряд весьма существенных преимуществ.
• Содержит более богатый и удобный набор элементов пользовательского интерфейса.
• Намного меньше зависит от той платформы, на которой должна выполняться программа. Следовательно, она меньше подвержена
  ошибкам, характерным для конкретной платформы.
• Обеспечивает одинаковое восприятие конечными пользователями приложений с ГПИ на разных платформах.
----------------------------------------------------------------------------------------------------------------------
ВНИМАНИЕ! Большинство имен компонентов из библиотеки Swing начинаются с буквы J. В качестве
примера можно привести классы JButton и JFrame. Они являются аналогами соответствующих
компонентов библиотеки AWT (например, Button и Frame). Если пропустить букву J в имени приме­
няемого компонента, программа скомпилируется и будет работать, но сочетание компонентов Swing
и AWT в одном окне приведет к несогласованности внешнего вида и поведения элементов ГПИ.
----------------------------------------------------------------------------------------------------------------------
Swing является частью библиотеки классов Java Foundation Classes (JFC). Полный комплект JFC огромен и содержит намного
больше, чем набор инструментальных средств Swing для разработки ГПИ. В состав JFC входят не только компоненты Swing, но
и прикладные программные интерфейсы API для специальных возможностей, двухмерной графики и перетаскивания.
----------------------------------------------------------------------------------------------------------------------
*/