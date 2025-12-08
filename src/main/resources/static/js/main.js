document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');

    var calendar = new FullCalendar.Calendar(calendarEl, {
        initialView: 'dayGridMonth',
        themeSystem: 'bootstrap5',
        headerToolbar: {
            left: 'prev,next today',
            center: 'title',
            right: 'dayGridMonth,timeGridWeek,timeGridDay'
        },

        events: '/api/appointments',
        eventColor: '#3788d8',
        eventTextColor: '#ffffff',

        // What happens when you click an appointment?
        eventClick: function(info) {
            alert('Appointment for: ' + info.event.title +
                '\nTime: ' + info.event.start.toLocaleTimeString());
        }
    });

    calendar.render();
});

