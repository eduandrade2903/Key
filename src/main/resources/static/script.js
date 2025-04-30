

function handleSubmit(formId, endpoint, getData, updateTable) {
    document.getElementById(formId).addEventListener('submit', async (e) => {
        e.preventDefault();
        const data = getData();
        try {
            const res = await fetch(`${api}/${endpoint}`, {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(data)
            });
            if (!res.ok) {
                const error = await res.json();
                throw new Error(error.message || 'Erro ao salvar o registro.');
            }
            await res.json(); // Ou res.text() se o backend não retornar JSON
            alert('Registro salvo com sucesso!');
            if (updateTable) updateTable();
        } catch (error) {
            alert('Erro: ' + error.message);
        }
    });
}

function popularSelect(endpoint, selectId, getLabel) {
    fetch(`${api}/${endpoint}`)
        .then(res => res.json())
        .then(data => {
            const select = document.getElementById(selectId);

            if (select) {
                data.forEach(item => {
                    const option = document.createElement('option');
                    option.value = item.id || item.idEmployee || item.idSector || item.idKey;
                    option.textContent = getLabel(item);
                    select.appendChild(option);
                });
            } else {
                console.error(`Elemento select com ID "${selectId}" não encontrado no DOM.`);
            }
        });
}

popularSelect('employee/all', 'idFuncionario', f => `${f.nameEmployee}`);
popularSelect('Key/all', 'idChaveEmprestimo', c => `${c.name}`);
popularSelect('Sector/all', 'idSetor', s => s.name);
popularSelect('Sector/all', 'idSetorChave', s => s.name);
popularSelect('Sector/all', 'idSetorAuth', s => s.name);