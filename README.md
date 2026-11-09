# Урок 8 · Biblioteci (JUnit и Swing)

Учебный проект Maven по всему уроку 8. Комментарии в коде на румынском, их можно показывать ученикам на проекторе.

## Как открыть

1. IntelliJ IDEA → **File → Open** → выбрать папку `lectia8` (ту, где лежит `pom.xml`) → **Open as Project**.
2. Подождать, пока IntelliJ скачает JUnit (внизу справа индикатор загрузки).
3. Если импорты `org.junit...` красные, нажать значок обновления Maven (слон или буква «m» с синими стрелками).
4. Нужна Java 17 или новее. Если у учеников Java 11, поменять в `pom.xml` строку `<maven.compiler.release>17</maven.compiler.release>` на 11.

## Что где лежит

| Файл | Что это | Слайды |
|---|---|---|
| `src/test/.../junit/AssertExamplesTest` | Три assert-метода из теории + бонус `assertThrows` и `@DisplayName` | 8–10 |
| `src/main/.../junit/DataClass` | Класс для тестирования, **с намеренным багом** в `charAt` | 11 |
| `src/test/.../junit/TestClass` | Тесты по ходу урока: первый тест, ещё два, решение задания «Teste» | 12–17 |
| `src/main/.../junit/Pangram` + `src/test/.../PangramTest` | ДЗ урока 7 и тесты к нему: мостик от ДЗ к теме | — |
| `src/main/.../swing/ButtonExample` | Окно с кнопкой | 21–25 |
| `src/main/.../swing/EventExample` | Поле ввода + `ActionListener` | 26–30 |
| `src/main/.../swing/Calculator` | Задание «Calculator» в точности как на слайдах | 31–35 |
| `src/main/.../swing/SwingTester` | Задание «Paleta» (`JColorChooser`) | 36–39 |
| `src/main/.../homework/CalculatorApp` + `CalculatorLogic` | Решение ДЗ урока 8: 4 операции + степень, обработка ошибок | ДЗ |
| `src/test/.../homework/CalculatorLogicTest` | Тесты к ДЗ: деление на ноль, отрицательные числа, ввод букв | ДЗ |

Swing-классы запускаются зелёной стрелкой у `main`. Тесты — стрелкой у класса (все тесты) или у метода (один тест). Все тесты проекта сразу: правый клик по папке `src/test/java` → **Run 'All Tests'**.

## Два теста падают специально

При первом запуске `TestClass` два теста красные — это и есть демонстрация с урока:

| Тест | Почему падает | Где ошибка | Как исправить |
|---|---|---|---|
| `testBool2` | `expected: <true> but was: <false>` | в **тесте**: ждём не тот результат | `assertTrue` → `assertFalse` |
| `testCharAt` | `StringIndexOutOfBoundsException: Index 4 out of bounds for length 4` | в **коде** `DataClass.charAt` | `position > str.length()` → `position >= str.length()` |

После обоих исправлений все тесты проекта зелёные. Мысль для учеников: красный тест — это не провал, а пойманный баг. И когда тест падает, проверять нужно и код, и сам тест.

## Нюансы, о которых спросят

- **`scope test`** в `pom.xml`: JUnit нужен только для тестов и не попадает в итоговую программу.
- **Swing в `pom.xml` не добавляется**: он входит в саму Java (`javax.swing`).
- **Тестовые классы** должны называться `...Test` или `Test...`, иначе `mvn test` их не найдёт. Поэтому `TestClass` подходит.
- **Импорты.** На слайдах импорты старого JUnit 4 (`org.junit.Test`, `junit.framework.Assert`). Здесь используется JUnit 5: `org.junit.jupiter.api.Test` и `org.junit.jupiter.api.Assertions`. Смешивать их нельзя.
- **`import java.awt.event.*`** обязателен для `ActionListener`, иначе он подсвечивается красным.
- **`setLayout(null)`** нужен, чтобы `setBounds` работал. В «Paleta» вместо этого используется `FlowLayout`, и элементы встают сами.
- **`EXIT_ON_CLOSE`** добавлен во все окна. Без него программа продолжает работать после закрытия окна.
- **Буква вместо числа** в `Calculator` выбрасывает `NumberFormatException` в консоль. В решении ДЗ это перехвачено, и в окне появляется понятное сообщение.
- **Деление на ноль с `double`** не даёт ошибки, а возвращает `Infinity`. Поэтому в `CalculatorLogic.divide` проверка на ноль сделана вручную.

## Gradle вместо Maven

Если в классе используют Gradle, вот `build.gradle`:

```groovy
plugins { id 'java' }

repositories { mavenCentral() }

dependencies {
    testImplementation 'org.junit.jupiter:junit-jupiter:5.11.0'
    testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
}

test { useJUnitPlatform() }
```
