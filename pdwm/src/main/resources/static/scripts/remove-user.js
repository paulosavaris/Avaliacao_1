//Script para remover usuarios
document.addEventListener("DOMContentLoaded", function () {
    // Adicione um ouvinte de evento a todos os botões de remoção
    const removeButtons = document.querySelectorAll(".remove-button");
    removeButtons.forEach(button => {
        button.addEventListener("click", function () {
            const memberId = this.getAttribute("data-member-id");

            // Confirmação antes de excluir o usuario
            const confirmDelete = confirm("Tem certeza de que deseja remover este membro?");
            if (!confirmDelete) return;
            // Envia uma solicitação para o servidor para remover o membro
            fetch(`/users/removeMember/${memberId}`, {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
            })
                .then(response => {
                    if (response.status === 200) {
                        alert("Membro Removido com sucesso.");
                        window.location.href = '/users'; // Recarrega a página
                        // Atualize a lista de membros após a remoção
                        // Você pode recarregar a página ou remover o membro da lista com JavaScript
                    } else {
                        alert("Erro ao remover o membro.");
                    }
                });
        });
    });
});