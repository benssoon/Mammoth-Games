INSERT INTO games (title,
                   min_players,
                   max_players,
                   game_status,
                   description)
VALUES ('Ticket to Ride',
        2,
        5,
        'OPEN',
        'A game about trains.');

INSERT INTO sessions (name,
                      game_id,
                      status)
VALUES ('Friday night trains',
        (SELECT id FROM games WHERE title = 'Ticket to Ride'),
        'OPEN');