function toggleMenu() {
    const menu = document.querySelector('.dropdown-menu');
    menu.classList.toggle('hidden'); // hidden 클래스를 추가/제거
    menu.classList.toggle('visible'); // visible 클래스를 추가/제거
}

function updateSortOption(event) {
    const selectedItem = event.target; // 클릭된 항목
    const sortOption = document.querySelector('.sort-option > div'); // '좋아요 순' 텍스트 위치
    sortOption.textContent = selectedItem.textContent; // 텍스트 변경
    toggleMenu(); // 메뉴 닫기
}

// 모든 드롭다운 항목에 클릭 이벤트 리스너 추가
document.querySelectorAll('.dropdown-menu .menu-item').forEach(item => {
    item.addEventListener('click', updateSortOption);
});

// 드롭다운 외부 클릭 시 메뉴 닫기
document.addEventListener('click', function (event) {
    const dropdown = document.querySelector('.sort-option');
    const menu = document.querySelector('.dropdown-menu');
    if (!dropdown.contains(event.target)) {
        menu.classList.add('hidden'); // 메뉴를 숨김
        menu.classList.remove('visible'); // 메뉴 보이기를 제거
    }
});