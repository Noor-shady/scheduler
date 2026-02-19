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

        eventColor: 'var(--primary-color, #0d6efd)',
        eventTextColor: '#ffffff',

        // UX Enhancement: Cleaner time formatting
        eventClick: (info) => {
            info.jsEvent.preventDefault();

            const eventTitle = info.event.title;

            // Format time nicely
            const startTime = info.event.start.toLocaleTimeString([], {
                hour: '2-digit',
                minute: '2-digit'
            });

            alert(`📅 Appointment: ${eventTitle}\n⏰ Time: ${startTime}`);
        }
    });

    calendar.render();
});