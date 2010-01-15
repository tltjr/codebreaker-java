Feature: code-breaker submits guess

    The code-breaker submits a guess of four colored
    pegs. The game marks the guess with black and
    white "marker" pegs.

    For each peg in the guess that matches the color
    and position of a peg in the secret code, the
    mark includes one black peg. For each additional
    peg in the guess that matches the color but not
    the position of a peg in the secret code, a
    white peg is added to the mark.

    Scenario: all four correct colors in correct positions
        Given the secret code is r g y c
        When I guess r g y c
        Then the mark should be bbbb

    Scenario: all four correct colors, two in correct positions
        Given the secret code is r g y c
        When I guess r g c y
        Then the mark should be bbww

    Scenario: all four correct colors, one in the correct position
        Given the secret code is r g y c
        When I guess y r g c
        Then the mark should be bwww

    Scenario: all four correct colors, none in correct positions
        Given the secret code is r g y c
        When I guess c r g y
        Then the mark should be wwww

    
