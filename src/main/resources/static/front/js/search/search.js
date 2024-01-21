function search() {
    let searchInput = document.getElementById('searchInput').value;


    if (searchInput.trim() !== "") {

        let xhr = new XMLHttpRequest();
        xhr.open('GET', '/search?skey=' + encodeURIComponent(searchInput), true);

        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {

                let searchResults = JSON.parse(xhr.responseText);

                displaySearchResults(searchResults);
            }
        };

        xhr.send();

        return false;
    }
}

function displaySearchResults(results) {

    let resultContainer = document.getElementById('searchResultsContainer');

    resultContainer.innerHTML = "";

    let resultList = document.createElement('ul');

    if (results.length === 0) {

        let noResultItem = document.createElement('li');
        noResultItem.textContent = '검색 결과가 없습니다.';
        resultList.appendChild(noResultItem);

    } else {

        results.forEach(function (result) {
            let resultItem = document.createElement('li');
            resultItem.textContent = result.title; // 예시: 결과의 제목을 표시
            resultList.appendChild(resultItem);
        });

    }

    resultContainer.appendChild(resultList);
}