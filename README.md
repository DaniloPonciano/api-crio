# Documentação da API de Gerenciamento de Eventos

> ## Pré-requisitos
>
> Antes de executar a API, certifique-se de ter os seguintes pré-requisitos instalados:
>
> - [Docker](https://www.docker.com/get-started)
>
> ## Passo a Passo para Execução
>
> 1. **Clone o Repositório**
>
>    Comece clonando o repositório em sua máquina local:
>
>    ```bash
>    git clone https://github.com/usuario/nome-do-repositorio.git
>    cd nome-do-repositorio
>    ```
>
> 2. **Construa a Imagem Docker**
>
>    Com o Docker instalado, construa a imagem da API com o seguinte comando:
>
>    ```bash
>    docker build -t gerenciador-eventos .
>    ```
>
> 3. **Execute o Contêiner**
>
>    Após a construção da imagem, execute o contêiner da API:
>
>    ```bash
>    docker run -d -p 3000:3000 gerenciador-eventos
>    ```
>
>    A API estará acessível na porta `3000`.
>
> 4. **Testando a API**
>
>    Para testar a API, faça uma requisição para o endpoint base:
>
>    ```bash
>    curl http://localhost:3000
>    ```
>
> 5. **Endpoints Disponíveis**
>
>    Aqui estão alguns dos principais endpoints da API:
>
>    - `GET /eventos` - Retorna a lista de eventos
>    - `POST /eventos` - Cria um novo evento
>    - `GET /eventos/:id` - Retorna um evento específico pelo ID
>    - `PUT /eventos/:id` - Atualiza um evento existente
>    - `DELETE /eventos/:id` - Deleta um evento
>
> ## Contribuição
>
> Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests.
>
> ## Licença
>
> Este projeto está licenciado sob a MIT License.
