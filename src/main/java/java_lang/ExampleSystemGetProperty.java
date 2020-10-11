package java_lang;

public class ExampleSystemGetProperty {
    public static void main(String args[]) {
        System.out.println("getProperty(\"user.dir\") -->   " + System.getProperty("user.dir"));
        System.out.println("getProperty(\"user.home\") -->   " + System.getProperty("user.home"));
        System.out.println("getProperty(\"user.name\") -->   " + System.getProperty("user.name"));
        System.out.println("getProperty(\"file.separator\") -->   " + System.getProperty("file.separator"));
        System.out.println("getProperty(\"java.class.path\") -->   " + System.getProperty("java.class.path"));
        System.out.println("getProperty(\"java.compoler\") -->   " + System.getProperty("java.compiler"));
        System.out.println("getProperty(\"java.ext.dirs\") -->   " + System.getProperty("java.ext.dirs"));
        System.out.println("getProperty(\"java.home\") -->   " + System.getProperty("java.home"));
        System.out.println("getProperty(\"java.io.tmpdir\") -->   " + System.getProperty("java.io.tmpdir"));
        System.out.println("getProperty(\"java.library.path\") -->   " + System.getProperty("java.library.path"));
        System.out.println("getProperty(\"java.specification.name\") -->   " + System.getProperty("java.specification.name"));
        System.out.println("getProperty(\"java.specification.vendor\") -->   " + System.getProperty("java.specification.vendor"));
        System.out.println("getProperty(\"java.specification.version\") -->   " + System.getProperty("java.specification.version"));
        System.out.println("getProperty(\"java.vendor\") -->   " + System.getProperty("java.vendor"));
        System.out.println("getProperty(\"java.vendor.url\") -->   " + System.getProperty("java.vendor.url"));
        System.out.println("getProperty(\"java.version\") -->   " + System.getProperty("java.version"));
        System.out.println("getProperty(\"java.vm.version\") -->   " + System.getProperty("java.vm.version"));
        System.out.println("getProperty(\"java.vm.name\") -->   " + System.getProperty("java.vm.name"));
        System.out.println("getProperty(\"java.vm.vendor\") -->   " + System.getProperty("java.vm.vendor"));
        System.out.println("getProperty(\"java.vm.specification.name\") -->   " + System.getProperty("java.vm.specification.name"));
        System.out.println("getProperty(\"java.vm.specification.vendor\") -->   " + System.getProperty("java.vm.specification.vendor"));
        System.out.println("getProperty(\"java.vm.specification.version\") -->   " + System.getProperty("java.vm.specification.version"));
        System.out.println("getProperty(\"line.separator\") -->   " + System.getProperty("line.separator"));
        System.out.println("getProperty(\"os.arch\") -->   " + System.getProperty("os.arch"));
        System.out.println("getProperty(\"os.name\") -->   " + System.getProperty("os.name"));
        System.out.println("getProperty(\"os.version\") -->   " + System.getProperty("os.version"));
        System.out.println("getProperty(\"path.separator\") -->   " + System.getProperty("path.separator"));
//        System.out.println("getProperty(\"\") -->   " + System.getProperty(""));

    }
}

/*
-------------------------------------------------------------------------------------------------------------------------
НАЗАМЕТКУ! Все имена свободно доступных системных свойств можно найти в файле security/java.policy, доступном в каталоге 
исполняющей системы Java.
-------------------------------------------------------------------------------------------------------------------------
•Properties getProperties()
	Извлекает все системные свойства. Прил ожение должно иметь право доступа ко всем свойствам,
	в противном случае генерируется исключение безопасности.
	
•String getProperty(String key)
	Извлекает системное свойство по заданному ключу. Если у приложения нет права доступа к дан ­
	ному свойству, то генерируется исключение безопасности. Следующие свойства всегда доступны для извлечения:
		java.version
		java.vendor
		java.vendor.ur1
		java.class.version
		os.name
		os.version
		os.arch
		file.separator
		path,separator
		line.separator
		java.specification.version
		java.vm.specification.version
		java.vm.specification.vendor
		java.vm.specification.name
		java.vm.version
		java.vm.vendor
		java.vm.name
-------------------------------------------------------------------------------------------------------------------------
*/