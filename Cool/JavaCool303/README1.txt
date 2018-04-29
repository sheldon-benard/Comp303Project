Design Patters:

Strategy:
    The Cool303Theme interface is the focal point of the strategy design pattern. Pastel.java and Summer.java are concrete theme strategies.
    The strategy is used in the constructor of Cool303Root and affects how the component is painted.

Composite:
    The Cool303Component interface is the focal point of the composite design pattern. Cool303Root, Cool303Container, Coool303Button and
    Cool303TextField all implement this method, and so setTheme() can be called on each of them. So, root can call setTheme and it will propagate down to every GUI component.

Decorator:
    Cool303Root decorates the add303Component() method of its parent(Cool303ContainerComponent).

Well-designed:
    A modified template-method pattern was used for Cool303ContainerComponent to reduce code-rewriting. Cool303ContainerComponent extends Cool303Component,
    and uses an abstract method to define setTheme. However, common container methods could be defined, that are shared between Cool303Container and Cool303Root

    Theme is propagated in such a way that the components can be configured first and then added to root, or the components added to root and then configured. The
    order does not matter.

    Utilized interfaces, abstract methods, implementation, inheritance extensively.

    Comments as documentation.

    Efficient runtime: resizing in root is determined as the user adds components (not after all components added).