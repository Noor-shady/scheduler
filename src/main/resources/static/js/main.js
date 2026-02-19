document.addEventListener('DOMContentLoaded', () => {
    const calendarEl = document.getElementById('calendar');

    if (!calendarEl) {
        console.error("Calendar element not found on this page.");
        return;
    }

    const calendar = new FullCalendar.Calendar(calendarEl, {
        initialView: 'dayGridMonth',
        themeSystem: 'bootstrap5',
        headerToolbar: {
            left: 'prev,next today',
            center: 'title',
            right: 'dayGridMonth,timeGridWeek,timeGridDay'
        },

        events: '/api/appointments',
        eventSourceFailure: (errorObj) => {
            console.error('Failed to fetch appointments from the API:', errorObj);
            // In a production app, I would trigger a Bootstrap Toast error message here
        },