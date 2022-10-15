<div align="center">
<h1 align="center"> Text2SpeechEditor </h1>
  <p align="center">
    A software application for writing documents and transforming them to audio
  </p>
</div>

<!-- ABOUT THE PROJECT -->
## About The Project

### Motivation

The development of this software application was part of the [Software Engineering][software-engineering-url] class, in order
to design a reusable-extendable object-oriented software using essential design patterns

### Design Patterns

The design patterns that were used for the design of this software application were:
* Command
* Parameterized Factory
* Strategy and Template Method
* Adapter

### Functionalities

* Create and edit the contents of document. The document hold a title, the author and a creation date
* Save/load the document to/from disk
* Transform the document, or a specific line, to audio, in order or in reverse order
* Encode the document, or a specific line, using Atbash or Rot-13 type of encodement and transform it to audio.

## Getting Started

### Prerequisites

The software application was developed using Java, Swing and the [Free TTS API][free-tts-api-url]

## Usage

Simply run MainApp.java

## License

See [License][license-url] for more information regarding the license

## Authors

Dimitris Anyfantakis

## Acknowledgments


[software-engineering-url]: https://www.cse.uoi.gr/~zarras/se.htm
[free-tts-api-url]: https://freetts.sourceforge.io/
[license-url]: https://github.com/dimanyfantakis/Text2SpeechEditor/blob/main/LICENSE