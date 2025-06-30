[README.md](https://github.com/user-attachments/files/20973562/README.md)
# 📢 AnunciarPlugin

Um plugin simples e leve para servidores 1.8.8 que permite que jogadores (administradores) anunciem mensagens para todos online via chat.

## ✨ Funcionalidades

- Comando `/anunciar <mensagem>` para enviar anúncios.
- Exibe mensagem no chat + título e subtítulo na tela.
- Configuração completa via `config.yml`.
- Suporte a cores com `&`.
- Comando `/anunciaradmin reload` para recarregar a configuração sem reiniciar o servidor.

## 🔧 Configuração (`config.yml`)

```yaml
# Mensagem exibida quando o comando é usado incorretamente
Alerta-Comando-Incorreto: "&cComando incorreto, use /anunciar <mensagem>"

# Mensagem enviada no chat (use %alerta% para representar a mensagem digitada)
Chat: "&f \n &eAnúncio:\n%alerta%\n &f"

# Título exibido na tela
Title: "&e&lAviso"

# Subtítulo exibido abaixo do título
SubTitle: "&eNovo anúncio!"

# Mensagem de erro de permissão
Sem-Permissao: "&cVocê não tem permissão para usar este comando!"

# Permissão necessária para o comando /anunciar
Permissao: "anunciar.usar"
```

## 🧵 Comandos

| Comando                  | Permissão             | Descrição                                 |
|--------------------------|-----------------------|-------------------------------------------|
| `/anunciar <mensagem>`   | `anunciar.usar`       | Envia um anúncio para todos os jogadores. |
| `/anunciaradmin reload`  | `anunciar.admin`      | Recarrega o plugin e o arquivo config.yml.|

## 🧩 Dependências

- Nenhuma! O plugin é 100% standalone, feito para **Spigot 1.8.8**.

## 🛠️ Compilação (Manual)

Caso deseje compilar o plugin:

1. Use **Java 8**.
2. Adicione o `spigot-1.8.8.jar` como dependência (sem empacotar).

## 📦 Download

Você pode compilar o plugin ou baixar o `.jar` já pronto na aba [Releases](https://github.com/travisfps/AnunciarPlugin/releases).

Feito com 💛 por Travis
