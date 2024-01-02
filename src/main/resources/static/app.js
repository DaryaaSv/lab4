document.addEventListener("DOMContentLoaded", function () {
    const tableSelect = document.getElementById('tableSelect');
    tableSelect.addEventListener('change', function () {
        showTable(tableSelect.value);
    });

    showTable('doctors');

    document.getElementById('sqlExecutorButton').addEventListener('click', openSqlExecutor);
});

function showTable(tableName) {
    fetch(`/api/${tableName}`)
        .then(response => response.json())
        .then(data => displayTable(data, tableName));
}

function displayTable(data, tableName) {
    const contentContainer = document.getElementById('content');
    contentContainer.innerHTML = `<h2>${tableName.charAt(0).toUpperCase() + tableName.slice(1)}</h2>`;

    if (data.length === 0) {
        contentContainer.innerHTML += '<p>No data available.</p>';
        return;
    }

    const table = document.createElement('table');
    const headerRow = document.createElement('tr');

    Object.keys(data[0]).forEach(key => {
        const th = document.createElement('th');
        th.textContent = key;
        headerRow.appendChild(th);
    });

    table.appendChild(headerRow);

    data.forEach(rowData => {
        const row = document.createElement('tr');

        Object.values(rowData).forEach(value => {
            const td = document.createElement('td');
            td.textContent = value;
            row.appendChild(td);
        });

        table.appendChild(row);
    });

    contentContainer.appendChild(table);
}

function openSqlExecutor() {
    window.location.href = 'db.html';
}
