# Stream Play
Apliativo de entretenimento que possibilita o usuário a assistir vídeos e ler artigos.

### Bibliotecas

#### Retrofit com OKHttp
Bibliotecas de HTTP Client para Android e Java

#### Picasso
Biblioteca para download de imagens da internet e cache das imagens

#### ButterKnith
Biblioteca quutiliza de anotações para realizar Binding de Campos e Métodos.

### Estrutura de pastas
Utilizando o padrão de arquitetura MVP a estrutura do projeto está organizada da seguinte forma:

#### Presenter e Database
Responsável por toda parte que controla a comunicação com serviços HTTP ou Banco de Dados
Pasta Presenter -> Estão todos os controladores que ralizam os serviços HTTP
Pasta DataBase -> Estão todos os controladores que ralizam os serviços utilizando Banco SQLite

#### Models
Pasta Models contem toda parte de modelo de daods do projeto

#### Ui
Pasta UI contém toda parte de views do projeto(Activities e Fragments).

