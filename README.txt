1.Изменить database.property  в папке src/main/resources рут и всех чайлд модулей
2.Накатить схему базы данных командой 'mvn clean package -P create_database'
3. Наполнить базу данных тестовыми данными командой `mvn install -P test_data`
4. Развернуть собранный war файл в любимом веб-сервере